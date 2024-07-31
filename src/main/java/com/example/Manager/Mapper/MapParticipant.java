package com.example.Manager.Mapper;

import com.example.Manager.Dto.ParticipantDto;
import com.example.Manager.Entity.Event;
import com.example.Manager.Entity.Participant;
import com.example.Manager.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapParticipant {
    @Autowired
    private EventRepository eventRepository;

    public ParticipantDto MapDtoParticipant(Participant participant) {
        ParticipantDto participantDto = new ParticipantDto();
        participantDto.setId(participant.getId());
        participantDto.setName(participant.getName());
        participantDto.setEmail(participant.getEmail());
        participantDto.setEventId(participant.getEvent().getId());
        return participantDto;
    }

    public Participant MapParticipant(ParticipantDto participantDto) {
        Participant participant = new Participant();
        participant.setId(participantDto.getId());
        participant.setName(participantDto.getName());
        participant.setEmail(participantDto.getEmail());
        Event event = eventRepository.findById(participantDto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));
        participant.setEvent(event);
        return participant;
    }
}

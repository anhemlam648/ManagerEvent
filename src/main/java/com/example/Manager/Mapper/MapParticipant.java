package com.example.Manager.Mapper;

import com.example.Manager.Dto.ParticipantDto;
import com.example.Manager.Entity.Participant;

public class MapParticipant {
    public static ParticipantDto MapDtoparticiant (Participant participant){
        ParticipantDto participantDto = new ParticipantDto();
        participantDto.setId(participant.getId());
        participantDto.setName(participant.getName());
        participantDto.setEmail(participant.getEmail());
        return participantDto;
    }
    public static Participant Mapparticiant (ParticipantDto participantDto){
        Participant participant = new Participant();
        participant.setId(participantDto.getId());
        participant.setName(participantDto.getName());
        participant.setEmail(participantDto.getEmail());
        return participant;
    }
}

package com.example.Manager.Service.Impl;
import com.example.Manager.Dto.ParticipantDto;
import com.example.Manager.Entity.Participant;
import com.example.Manager.Mapper.MapParticipant;
import com.example.Manager.Repository.ParticipantRepository;
import com.example.Manager.Service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public ParticipantDto createParticipant(ParticipantDto participantDto) {
        Participant participant = MapParticipant.Mapparticiant(participantDto);
        Participant savedParticipant = participantRepository.save(participant);
        return MapParticipant.MapDtoparticiant(savedParticipant);
    }

    @Override
    public ParticipantDto updateParticipant(Long id, ParticipantDto participantDto) {
        Participant existingParticipant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found"));
        existingParticipant.setName(participantDto.getName());
        existingParticipant.setEmail(participantDto.getEmail());
        participantRepository.save(existingParticipant);
        return MapParticipant.MapDtoparticiant(existingParticipant);
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }

    @Override
    public ParticipantDto getParticipantById(Long id) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found"));
        return MapParticipant.MapDtoparticiant(participant);
    }

    @Override
    public List<ParticipantDto> getAllParticipants() {
        return participantRepository.findAll().stream()
                .map(MapParticipant::MapDtoparticiant)
                .collect(Collectors.toList());
    }
}

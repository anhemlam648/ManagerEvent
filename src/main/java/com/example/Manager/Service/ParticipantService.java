package com.example.Manager.Service;

import com.example.Manager.Dto.ParticipantDto;

import java.util.List;

public interface ParticipantService {
    ParticipantDto createParticipant(ParticipantDto participantDto);
    ParticipantDto updateParticipant(Long id, ParticipantDto participantDto);
    void deleteParticipant(Long id);
    ParticipantDto getParticipantById(Long id);
    List<ParticipantDto> getAllParticipants();
}

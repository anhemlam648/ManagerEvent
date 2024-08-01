package com.example.Manager.Controller;

import com.example.Manager.Dto.ParticipantDto;
import com.example.Manager.Service.ConfigService;
import com.example.Manager.Service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/participants")
@CrossOrigin("http://localhost:3030")
public class ControllerParticipant {
    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ConfigService configService;

    @RequestMapping("/service")
    public String testService() {
        configService.performService();
        return "Service performed successfully";
    }

    @PostMapping
    public ResponseEntity<ParticipantDto> createParticipant(@RequestBody ParticipantDto participantDto) {
        ParticipantDto createdParticipant = participantService.createParticipant(participantDto);
        return ResponseEntity.ok(createdParticipant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDto> updateParticipant(@PathVariable Long id, @RequestBody ParticipantDto participantDto) {
        ParticipantDto updatedParticipant = participantService.updateParticipant(id, participantDto);
        return ResponseEntity.ok(updatedParticipant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDto> getParticipantById(@PathVariable Long id) {
        ParticipantDto participantDto = participantService.getParticipantById(id);
        return ResponseEntity.ok(participantDto);
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> getAllParticipants() {
        List<ParticipantDto> participants = participantService.getAllParticipants();
        return ResponseEntity.ok(participants);
    }
}

package com.example.Manager.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParticipantDto {

    private Long id;
    private String name;
    private String email;
    private Long eventId;
}

package com.example.Manager.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationDto {

    private Long id;
    private String name;
    private String location;
    private int capacity;
    private Set<Long> eventIds;
}

package com.example.Manager.Mapper;

import com.example.Manager.Dto.LocationDto;
import com.example.Manager.Entity.Event;
import com.example.Manager.Entity.Location;
import com.example.Manager.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MapLocation {

    @Autowired
    private EventRepository eventRepository;

    public LocationDto MapDtoLocation(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setLocation(location.getLocation());
        locationDto.setCapacity(location.getCapacity());
        locationDto.setEventIds(location.getEvents().stream().map(Event::getId).collect(Collectors.toSet()));
        return locationDto;
    }

    public Location MapLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setLocation(locationDto.getLocation());
        location.setCapacity(locationDto.getCapacity());
        location.setEvents(locationDto.getEventIds().stream()
                .map(eventRepository::findById)
                .map(optionalEvent -> optionalEvent.orElseThrow(() -> new RuntimeException("Event not found")))
                .collect(Collectors.toSet()));
        return location;
    }
}

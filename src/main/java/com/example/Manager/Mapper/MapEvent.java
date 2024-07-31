package com.example.Manager.Mapper;

import com.example.Manager.Dto.EventDto;
import com.example.Manager.Entity.Event;
import com.example.Manager.Entity.Location;
import com.example.Manager.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapEvent {
    @Autowired
    private LocationRepository locationRepository;

    public EventDto MapDtoEvent(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());
        eventDto.setLocationId(event.getLocation().getId());
        return eventDto;
    }

    public Event MapEvent(EventDto eventDto) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        Location location = locationRepository.findById(eventDto.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));
        event.setLocation(location);
        return event;
    }
}

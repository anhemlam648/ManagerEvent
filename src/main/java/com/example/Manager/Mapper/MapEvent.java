package com.example.Manager.Mapper;

import com.example.Manager.Dto.EventDto;
import com.example.Manager.Entity.Event;

public class MapEvent {
    public static EventDto MapDtoEvent(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());
        return eventDto;
    }
    public static Event MapEvent(EventDto eventDto){
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        return event;
    }
}

package com.example.Manager.Service;

import com.example.Manager.Dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto updateEvent(Long id, EventDto eventDto);
    void deleteEvent(Long id);
    EventDto getEventById(Long id);
    List<EventDto> getAllEvents();
}

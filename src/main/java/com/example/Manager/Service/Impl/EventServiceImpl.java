package com.example.Manager.Service.Impl;

import com.example.Manager.Dto.EventDto;
import com.example.Manager.Entity.Event;
import com.example.Manager.Mapper.MapEvent;
import com.example.Manager.Repository.EventRepository;
import com.example.Manager.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MapEvent mapEvent;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = mapEvent.MapEvent(eventDto);
        event = eventRepository.save(event);
        return mapEvent.MapDtoEvent(event);
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setName(eventDto.getName());
        existingEvent.setDescription(eventDto.getDescription());
        existingEvent.setStartDate(eventDto.getStartDate());
        existingEvent.setEndDate(eventDto.getEndDate());
        eventRepository.save(existingEvent);
        return mapEvent.MapDtoEvent(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return mapEvent.MapDtoEvent(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(mapEvent::MapDtoEvent)
                .collect(Collectors.toList());
    }
}

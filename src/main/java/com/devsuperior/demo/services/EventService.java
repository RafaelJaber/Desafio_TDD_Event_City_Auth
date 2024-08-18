package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final CityRepository cityRepository;

    public EventService(
            EventRepository eventRepository,
            CityRepository cityRepository
    ) {
        this.eventRepository = eventRepository;
        this.cityRepository = cityRepository;
    }

    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> eventPage = eventRepository.findAll(pageable);
        return eventPage.map(EventDTO::new);
    }

    @Transactional
    public EventDTO insert(EventDTO dto) {
        Event entity = new Event();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());

        entity.setCity(cityRepository.getReferenceById(dto.getCityId()));

        Event inserted = eventRepository.save(entity);
        return new EventDTO(inserted);
    }

    @Transactional
    public EventDTO update(EventDTO eventDTO, Long eventId) {
        try {
            Event event = eventRepository.getReferenceById(eventId);
            event.setName(eventDTO.getName());
            event.setDate(eventDTO.getDate());
            event.setUrl(eventDTO.getUrl());

            City city = cityRepository.getReferenceById(eventDTO.getCityId());
            event.setCity(city);

            Event updated = eventRepository.save(event);
            return new EventDTO(updated);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound("Event not found");
        }
    }
}

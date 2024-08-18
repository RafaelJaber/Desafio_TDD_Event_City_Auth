package com.devsuperior.demo.controllers;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(
            @PathVariable Long id,
            @RequestBody EventDTO eventDTO
    ) {
        EventDTO updated = eventService.update(eventDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}

package com.example.mymiau.controller;

import com.example.mymiau.event.CustomEvent;
import com.example.mymiau.event.StandardEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private final ApplicationEventPublisher publisher;

    public EventController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;}

    @GetMapping("/standard")
    public String triggerStandardEvent() {
        publisher.publishEvent(new StandardEvent(this, "standard event triggered"));
        return "standard event published";}

    @GetMapping("/custom")
    public String triggerCustomEvent() {
        publisher.publishEvent(new CustomEvent("custom event triggered"));
        return "custom event published";}}
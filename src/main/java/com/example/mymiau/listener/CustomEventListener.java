package com.example.mymiau.listener;

import com.example.mymiau.event.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {
    @Async
    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("[ASYNC] handling CustomEvent: " + event.getMessage());}}
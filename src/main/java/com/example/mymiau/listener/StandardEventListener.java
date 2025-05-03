package com.example.mymiau.listener;

import com.example.mymiau.event.StandardEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StandardEventListener {
    @Async
    @EventListener
    public void handleStandardEvent(StandardEvent event) {
        System.out.println("[ASYNC] handling StandardEvent: " + event.getMessage());}}
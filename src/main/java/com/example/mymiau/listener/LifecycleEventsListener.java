package com.example.mymiau.listener;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class LifecycleEventsListener {

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        System.out.println("📦 ContextRefreshedEvent: la aplicación fue iniciada");}

    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
        System.out.println("📦 ContextStartedEvent: la aplicación fue iniciada");}

    @EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
        System.out.println("📦 ContextStoppedEvent: la aplicación fue detenida");}

    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
        System.out.println("📦 ContextClosedEvent: la aplicación fue detenida");}

    @EventListener
    public void handleRequestHandled(RequestHandledEvent event) {
        System.out.println("📦 RequestHandledEvent: se procesó un request HTTP");}}
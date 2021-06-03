package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventStore {
    Logger logger = LoggerFactory.getLogger(EventStore.class);

    private final List<Event> events = new ArrayList<>();

    public void create(Event event) {
        events.add(event);
        logger.info("Event created: <" + event.getClass().getSimpleName() + ">, transaction id: " + event.getTransactionId());
    }

    public List<Event> getEvents() {
        return events;
    }
}

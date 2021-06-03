package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.event.Event;

public interface EventProcessor {
    void process(Event event);
}

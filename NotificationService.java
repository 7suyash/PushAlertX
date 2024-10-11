package org.example;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Subscriber> subscribers;

    public NotificationService() {
        subscribers = new ArrayList<>();
    }

    // Add subscriber
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Remove subscriber
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Send notification to all subscribers
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveNotification(message);
        }
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
}
}
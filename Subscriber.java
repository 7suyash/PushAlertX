package org.example;

public class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receiveNotification(String message) {
        // Display a dialog box for the notification
        javax.swing.JOptionPane.showMessageDialog(null, name + ", you have a new notification: " + message);
}
}
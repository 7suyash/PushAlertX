package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private NotificationService notificationService;
    private JTextField subscriberNameField;
    private JTextArea notificationMessageArea;
    private DefaultListModel<String> listModel;
    private JList<String> subscriberList;

    public Main() {
        notificationService = new NotificationService();
        setTitle("Notification System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Subscriber name input
        JLabel nameLabel = new JLabel("Subscriber Name:");
        nameLabel.setBounds(20, 20, 120, 20);
        add(nameLabel);

        subscriberNameField = new JTextField();
        subscriberNameField.setBounds(150, 20, 150, 20);
        add(subscriberNameField);

        // Add Subscriber Button
        JButton addButton = new JButton("Subscribe");
        addButton.setBounds(310, 20, 100, 20);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = subscriberNameField.getText();
                if (!name.isEmpty()) {
                    Subscriber newSubscriber = new Subscriber(name);
                    notificationService.subscribe(newSubscriber);
                    listModel.addElement(name);
                    subscriberNameField.setText("");
                }
            }
        });

        // Subscriber list
        listModel = new DefaultListModel<>();
        subscriberList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(subscriberList);
        scrollPane.setBounds(20, 60, 150, 150);
        add(scrollPane);

        // Remove Subscriber Button
        JButton removeButton = new JButton("Unsubscribe");
        removeButton.setBounds(180, 60, 100, 20);
        add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSubscriber = subscriberList.getSelectedValue();
                if (selectedSubscriber != null) {
                    for (Subscriber s : notificationService.getSubscribers()) {
                        if (s.getName().equals(selectedSubscriber)) {
                            notificationService.unsubscribe(s);
                            listModel.removeElement(selectedSubscriber);
                            break;
                        }
                    }
                }
            }
        });

        // Notification message input
        JLabel messageLabel = new JLabel("Notification Message:");
        messageLabel.setBounds(20, 220, 150, 20);
        add(messageLabel);

        notificationMessageArea = new JTextArea();
        notificationMessageArea.setBounds(180, 220, 150, 50);
        add(notificationMessageArea);

        // Notify Button
        JButton notifyButton = new JButton("Notify All");
        notifyButton.setBounds(340, 220, 100, 20);
        add(notifyButton);
        notifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = notificationMessageArea.getText();
                if (!message.isEmpty()) {
                    notificationService.notifySubscribers(message);
                    notificationMessageArea.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}

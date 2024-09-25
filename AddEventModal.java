import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;


public class AddEventModal extends JDialog {
    private JTextField name;
    private JTextField location;
    private JTextField endTime;
    private JTextField startTime;
    private EventListPanel eventListPanel;

    public AddEventModal(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;
        setTitle("Create Event");
        pack();
        setVisible(true);
        setModal(true);
        setSize(800,500);

        JButton createEventButton = new JButton("Create Event");
        createEventButton.addActionListener(x -> CreateEvent());
        add(createEventButton);

        name = new JTextField();
        add(new JLabel("Event Name: " + add(name)));
        location = new JTextField();
        add (new JLabel("Location: " + add(location)));
        endTime = new JTextField();
        add(new JLabel("EndDate: " + add(endTime)));
        startTime = new JTextField();
        add(new JLabel("StartTime: " + add(startTime)));
    }

    private void CreateEvent() {
        String eventName = String.valueOf(name);
        String eventlocation = String.valueOf(location);
        LocalDateTime eventStartTime = LocalDateTime.parse(startTime.getText());
        Deadline eventDeadline = new Deadline(eventName, eventStartTime);
        dispose();
    }

}

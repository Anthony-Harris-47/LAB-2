import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    public EventPanel(Event event) {
        this.event = event;
        setPreferredSize(new Dimension(800, 50));
        setBackground(Color.GRAY);
        String completed = "FALSE";

        JLabel LabelName = new JLabel("Event Name: " + event.getName());
        JLabel LabelTime = new JLabel("Time: " + event.getDateTime());

        add(LabelName);
        add(LabelTime);

        if (event instanceof Meeting meeting) {
            JLabel LabelDuration = new JLabel("Duration: " + meeting.getDuration());
            add(LabelDuration);

            JLabel LabelLocation = new JLabel("Location: " + meeting.getLocation());
            add(LabelLocation);
        }

        if (event instanceof Completable completable) {
            JLabel LabelComplete = new JLabel("COMPLETED: " + completable.isComplete());
            add(LabelComplete);
            add(completeButton);
            completeButton.addActionListener(x -> {
                completable.complete();
                if (completable.isComplete()) {
                    LabelComplete.setText("TRUE");
                } else {
                    LabelComplete.setText("FALSE");
                }
            });


            completeButton.addActionListener(j -> {
                ((Completable) event).complete();
                removeAll();
                revalidate();
                repaint();
            });
        }

    }
}

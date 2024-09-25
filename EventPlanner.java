import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
public class EventPlanner{
        public static void main(String[] args) {
                JFrame frame = new JFrame("Event Planner");
                frame.setTitle("Control Options");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.getContentPane().setBackground(Color.LIGHT_GRAY);
                frame.setVisible(true);

                EventListPanel eventListPanel = new EventListPanel();
                createDefaultEvents(eventListPanel);
                frame.add(eventListPanel);

                frame.pack();
                frame.setSize(new Dimension(800,600));
                frame.setVisible(true);
        }

        public static void createDefaultEvents(EventListPanel eventListPanel) {
                Deadline defaultDeadline = new Deadline("Test",LocalDateTime.of(2024,1,4,2,30));
                Meeting defaultMeeting = new Meeting("CS Building", LocalDateTime.of(2024,1,4,2,30), LocalDateTime.of(2024,2,21,2,30), "My House");
                eventListPanel.createEvent(defaultDeadline);
                eventListPanel.createEvent(defaultMeeting);
        }
}


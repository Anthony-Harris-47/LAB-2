import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel displayPanel;

    public EventListPanel(){
        setPreferredSize(new Dimension(800,500));
        setBackground(Color.GRAY);
        events = new ArrayList<>();

        displayPanel = new JPanel();
        JButton createEventButton = new JButton("Add Event");
        createEventButton.addActionListener(x -> {
            AddEventModal buttonModal = new AddEventModal (this);
        buttonModal.setVisible(true);
        });
        displayPanel.add(createEventButton);
        add(displayPanel);

    }

    public void createEvent(Event event){
        events.add(event);
        update();
    }

    private void update(){
        displayPanel.removeAll();
        displayPanel.revalidate();
        displayPanel.repaint();
    }
}
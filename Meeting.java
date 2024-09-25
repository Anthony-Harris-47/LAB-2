import java.time.LocalDateTime;
import java.time.Duration;

public class Meeting extends Event implements Completable {
    private String location;
    private LocalDateTime endDateTime;
    private boolean complete;

    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String Location) {
        super(name, dateTime);
        this.endDateTime = endDateTime;
        this.location = location;
    }

    @Override
    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return this.complete;
    }

    public LocalDateTime getEndDate() {
        return this.endDateTime;
    }

    public Duration getDuration(){
        return Duration.between(getDateTime(), getEndDate());
    }

    public String getLocation(){
        return this.location;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setLocation(String location){
        this.location = location;
    }
}

import java.time.LocalDateTime;

public class ThePojo {
    private LocalDateTime timestamp;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime created) {
        this.timestamp = created;
    }
}
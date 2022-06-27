package week8.homework1;

import java.time.LocalDateTime;

public class LogFileRow {

    private final int id;
    private final LocalDateTime time;
    private final String fullName;
    private final String number;
    private final String text;

    public LogFileRow(int id, LocalDateTime time, String fullName, String number, String text) {
        this.id = id;
        this.time = time;
        this.fullName = fullName;
        this.number = number;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "LogFileRow{" +
                "id=" + id +
                ", time=" + time +
                ", fullName='" + fullName + '\'' +
                ", number='" + number + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

package week8.homework1.Thread;

import week8.homework1.LogFileParser;
import week8.homework1.LogFileRow;
import week8.homework1.NewQueueCreator;
import week8.homework1.RandomUtils.RandomUtils;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ComplaintsParser extends Thread {

    private final LogFileParser parser = new LogFileParser();
    private final NewQueueCreator creator = new NewQueueCreator();
    private final Path pathToComplaintsLogFile;
    private final BlockingQueue<LogFileRow> complaints;
    private boolean isActive;

    public ComplaintsParser(Path pathToComplaintsLogFile, BlockingQueue<LogFileRow> complaints) {
        this.pathToComplaintsLogFile = pathToComplaintsLogFile;
        this.complaints = complaints;
        this.isActive = true;
    }

    @Override
    public void run() {
        while (isActive) {
            List<LogFileRow> parsedList = parser.parse(pathToComplaintsLogFile);
            List<LogFileRow> newComplaints = creator.getListOfNewComplaints(parsedList);
            try {
                for (LogFileRow logFileRow : newComplaints) {
                    complaints.put(logFileRow);
                }
                Thread.sleep(RandomUtils.PERIOD);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void disable() {
        isActive = false;
    }
}

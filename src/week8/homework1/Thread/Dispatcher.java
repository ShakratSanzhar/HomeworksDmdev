package week8.homework1.Thread;

import week8.homework1.LogFileRow;
import week8.homework1.RandomUtils.RandomUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;

public class Dispatcher extends Thread{

    private final BlockingQueue<LogFileRow> complaints;
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");
    private final Path pathToProcessedComplaintsFile =Path.of("src","week8","homework1","processedComplaints.txt");
    private final ComplaintsParser parser;

    public Dispatcher(BlockingQueue<LogFileRow> complaints, ComplaintsParser parser) {
        this.complaints = complaints;
        this.parser = parser;
    }

    @Override
    public void run() {
        while(parser.isActive()){
            try {
                LogFileRow complaint = complaints.take();
                System.out.println(Thread.currentThread().getName() + " начал звонок");
                Thread.sleep(RandomUtils.CALL);
                System.out.println(Thread.currentThread().getName() + " завершил звонок");
                synchronized (pathToProcessedComplaintsFile) {
                    Files.writeString(pathToProcessedComplaintsFile, complaint.getId() + "," + LocalDateTime.now().format(FORMATTER) + "," + complaint.getNumber() + System.lineSeparator(), StandardOpenOption.APPEND);
                    System.out.println(Thread.currentThread().getName() + " записал данные о звонке");
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

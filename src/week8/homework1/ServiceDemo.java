package week8.homework1;

import week8.homework1.RandomUtils.RandomUtils;
import week8.homework1.Thread.ComplaintsAdder;
import week8.homework1.Thread.ComplaintsParser;
import week8.homework1.Thread.Dispatcher;

import java.nio.file.Path;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ServiceDemo {

    public static void main(String[] args) {
        BlockingQueue<LogFileRow> complaintsQueue = new ArrayBlockingQueue<>(RandomUtils.AMOUNT);
        var complaintsFile = Path.of("src", "week8", "homework1", "complaintsLogFile.txt");
        ComplaintsParser parser = new ComplaintsParser(complaintsFile, complaintsQueue);
        Dispatcher dispatcher1 = new Dispatcher(complaintsQueue, parser);
        Dispatcher dispatcher2 = new Dispatcher(complaintsQueue, parser);
        dispatcher1.setName("Диспетчер №1");
        dispatcher2.setName("Диспетчер №2");
        ComplaintsAdder randomComplaint = new ComplaintsAdder(complaintsFile, parser);
        parser.start();
        dispatcher1.start();
        dispatcher2.start();
        randomComplaint.start();
    }
}

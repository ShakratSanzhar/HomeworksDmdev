package week8.homework1.Thread;

import week8.homework1.RandomUtils.RandomUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ComplaintsAdder extends Thread {

    private final Path pathToComplaintsLogFile;
    private final ComplaintsParser parser;

    public ComplaintsAdder(Path pathToComplaintsLogFile, ComplaintsParser parser) {
        this.pathToComplaintsLogFile = pathToComplaintsLogFile;
        this.parser = parser;
    }

    @Override
    public void run() {
        for (int i = RandomUtils.ID; parser.isActive(); i++) {
            try {
                Files.writeString(pathToComplaintsLogFile, i + "," + RandomUtils.getRandomComplaint() + System.lineSeparator(), StandardOpenOption.APPEND);
                Thread.sleep(RandomUtils.DURATION);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

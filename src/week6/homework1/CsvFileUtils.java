package week6.homework1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class CsvFileUtils {

    private static final String DELIMITER = ",";
    private static final int FIRSTCOLUMN = 0;
    private static final int SECONDCOLUMN = 1;
    private static final int FIRSTROW = 0;

    private CsvFileUtils() {
    }

    public static List<Record> getDataFromTwoFiles(Path path1, Path path2) throws IOException {
        List<String> dataFromFirstFile = Files.readAllLines(path1);
        List<String> dataFromSecondFile = Files.readAllLines(path2);
        List<Record> records = new ArrayList<>();
        for (int i = FIRSTROW; i < dataFromFirstFile.size(); i++) {
            Record record = new Record();
            Scanner rowScannerOfFirstFile = new Scanner(dataFromFirstFile.get(i));
            Scanner rowScannerOfSecondFile = new Scanner(dataFromSecondFile.get(i));
            rowScannerOfFirstFile.useDelimiter(DELIMITER);
            rowScannerOfSecondFile.useDelimiter(DELIMITER);
            int column = FIRSTCOLUMN;
            while (rowScannerOfFirstFile.hasNext() && rowScannerOfSecondFile.hasNext()) {
                String rowFromFirstFile = rowScannerOfFirstFile.next();
                String rowFromSecondFile = rowScannerOfSecondFile.next();
                switch (column) {
                    case FIRSTCOLUMN -> record.setId(rowFromFirstFile);
                    case SECONDCOLUMN -> {
                        record.setPrice(rowFromFirstFile);
                        record.setName(rowFromSecondFile);
                    }
                }
                column++;
            }
            records.add(record);
        }
        return records;
    }

    public static void writeDataToResultFile(Path path, List<Record> records) throws IOException {
        List<String> data = records.stream()
                .filter(record -> record.getName() != null || record.getPrice() != null)
                .map(record -> record.getId() + "," + record.getName() + "," + record.getPrice())
                .collect(Collectors.toList());
        StringBuilder resultData = new StringBuilder();
        for (String row : data) {
            resultData.append(row).append(System.lineSeparator());
        }
        Files.write(path, resultData.toString().getBytes(), StandardOpenOption.WRITE);
    }

    public static void writeDataToErrorsFile(Path path, List<Record> records) throws IOException {
        List<String> data = records.stream()
                .filter(record -> record.getName() == null && record.getPrice() == null)
                .map(Record::getId)
                .collect(Collectors.toList());
        StringBuilder resultData = new StringBuilder();
        for (String row : data) {
            resultData.append(row).append(System.lineSeparator());
        }
        Files.write(path, resultData.toString().getBytes(), StandardOpenOption.WRITE);
    }
}

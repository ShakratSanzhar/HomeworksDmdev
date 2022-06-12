package week6.homework1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CsvFileRunner {

    public static void main(String[] args) throws IOException {
        Path pathPriceFile = Path.of("src", "week6", "homework1", "items-price.csv");
        Path pathNameFile = Path.of("src", "week6", "homework1", "items-name.csv");
        Path pathResultFile = Path.of("src", "week6", "homework1", "result.csv");
        Path pathErrorsFile = Path.of("src", "week6", "homework1", "errors.csv");
        List<Record> records = CsvFileUtils.getDataFromTwoFiles(pathPriceFile, pathNameFile);
        CsvFileUtils.writeDataToResultFile(pathResultFile, records);
        CsvFileUtils.writeDataToErrorsFile(pathErrorsFile, records);
    }
}

package week8.homework1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileParser {

    private static final String REGEX = "(?<id>\\d\\d?),(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})T(?<hours>\\d{2}):(?<minutes>\\d{2}):(?<seconds>\\d{2}),(?<fullName>[А-Яа-я]* [А-Яа-я]*),(?<number>(\\+375)? ?\\d{2} ?\\d{3} ?\\d{2} ?\\d{2}),(?<text>[А-Яа-я ?-]*)";
    private static final String NUMBERREGEX = "(\\+375)? ?(\\d{2}) ?(\\d{3}) ?(\\d{2}) ?(\\d{2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public List<LogFileRow> parse(Path path) {
        List<LogFileRow> rows = null;
        try {
            rows = buildLogFileRows(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

    private List<LogFileRow> buildLogFileRows(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(this::buildLogFileRow)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
    }

    private Optional<LogFileRow> buildLogFileRow(String line) {
        return Optional.of(line)
                .map(PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> {
                    var id = Integer.parseInt(matcher.group("id"));
                    var year = Integer.parseInt(matcher.group("year"));
                    var month = Integer.parseInt(matcher.group("month"));
                    var day = Integer.parseInt(matcher.group("day"));
                    var hours = Integer.parseInt(matcher.group("hours"));
                    var minutes = Integer.parseInt(matcher.group("minutes"));
                    var seconds = Integer.parseInt(matcher.group("seconds"));
                    var fullName = matcher.group("fullName");
                    var number = matcher.group("number");
                    var numberResult = number.replaceAll(NUMBERREGEX, "+375 ($2) $3-$4-$5");
                    var text = matcher.group("text");
                    return new LogFileRow(id, LocalDateTime.of(year, month, day, hours, minutes, seconds), fullName, numberResult, text);
                });
    }
}

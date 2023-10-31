package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;

public class NameParserImpl implements NameParser {
    private final String DELIMITER = ",";

    @Override
    public List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER, -1)).toList();
    }
}

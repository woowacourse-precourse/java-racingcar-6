package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;

public class CarNameParserImpl implements CarNameParser {
    private final String DELIMITER = ",";

    @Override
    public List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }
}

package racingcar.converter;

import java.util.List;

public class RaceConverter {
    private static final String DELIMITER = ",";

    public List<String> convertToList(String input) {
        return List.of(input.split(DELIMITER));
    }
}

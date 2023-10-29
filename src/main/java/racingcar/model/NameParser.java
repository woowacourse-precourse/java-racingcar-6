package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    public List<String> parseName(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }
}

package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static final List<String> carNameParser(final String inputCarName) {
        return Arrays.asList(inputCarName.split(","));
    }
}

package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> carNameParser(String inputCarName) {
        return Arrays.asList(inputCarName.split(","));
    }
}

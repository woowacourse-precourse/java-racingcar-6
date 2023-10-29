package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> carNameParser(String inputCarName) {
        return Arrays.asList(inputCarName.split(","));
    }
}

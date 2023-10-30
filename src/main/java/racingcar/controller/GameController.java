package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class GameController {
    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}

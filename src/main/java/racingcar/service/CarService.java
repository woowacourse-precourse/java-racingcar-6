package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class CarService {
    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}

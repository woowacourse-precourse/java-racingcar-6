package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public static void main(String[] args) {

    }
}

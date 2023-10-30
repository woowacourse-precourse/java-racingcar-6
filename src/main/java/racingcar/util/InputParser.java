package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class InputParser {
    private static final String DELIMITER = ",";

    public List<Car> parseCarName(String playerInput) {
        List<Car> result = new ArrayList<>();
        List<String> carNames = Arrays.stream(playerInput.split(DELIMITER)).toList();
        for (String carName : carNames) {
            result.add(new Car(carName));
        }
        return result;
    }

    public int parseNumberOfAttempt(String playerInput) {
        return Integer.parseInt(playerInput);
    }
}

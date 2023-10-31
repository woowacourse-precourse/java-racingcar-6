package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.consts.ViewConstant;
import racingcar.domain.Car;

public class InputParser {
    InputValidator inputValidator = new InputValidator();

    public List<Car> parseCarName(String playerInput) {
        inputValidator.validateCarNames(playerInput);
        List<Car> result = new ArrayList<>();
        List<String> carNames = Arrays.stream(playerInput.split(ViewConstant.DELIMITER.get())).toList();
        for (String carName : carNames) {
            result.add(new Car(carName));
        }
        return result;
    }

    public int parseNumberOfAttempt(String playerInput) {
        inputValidator.validateNumberOfAttempt(playerInput);
        return Integer.parseInt(playerInput);
    }
}

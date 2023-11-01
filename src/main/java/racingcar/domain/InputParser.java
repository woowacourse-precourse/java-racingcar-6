package racingcar.domain;

import static racingcar.consts.ViewConstant.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final InputValidator inputValidator = new InputValidator();

    public List<Car> parseCarName(String playerInput) {
        playerInput = removeSpaces(playerInput);
        inputValidator.validateCarNames(playerInput);
        return createCarList(playerInput);
    }

    public int parseNumberOfAttempt(String playerInput) {
        playerInput = removeSpaces(playerInput);
        inputValidator.validateNumberOfAttempt(playerInput);
        return Integer.parseInt(playerInput);
    }

    private List<Car> createCarList(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER.get()))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String removeSpaces(String playerInput) {
        return playerInput.replaceAll(" ", "");
    }
}

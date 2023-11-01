package racingcar.domain;

import racingcar.common.Converter;
import racingcar.common.InputValidator;

import java.util.Map;

public class User {
    private static final InputValidator inputValidator = new InputValidator();

    private Map<String, Integer> cars;
    private int gameCount;

    public Map<String, Integer> getCars(String input) {
        this.cars = Converter.stringToMap(input);
        inputValidator.carNameValidator(cars);
        return cars;
    }

    public int getGameCount(String input) {
        this.gameCount = Converter.stringToInteger(input);
        inputValidator.gameCountValidator(gameCount);
        return gameCount;
    }
}

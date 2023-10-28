package racingcar.domain;

import racingcar.utils.validation.InputValidation;

public class Race {
    private Cars cars;
    private int moveCount;

    public Race(String carNames, String count) {
        this.cars = new Cars(carNames);
        this.moveCount = convertStringToInt(count);
        InputValidation.validateCountRange(moveCount);
    }

    private int convertStringToInt(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

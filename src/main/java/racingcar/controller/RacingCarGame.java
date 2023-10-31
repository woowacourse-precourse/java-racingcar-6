package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.InputValidator;

public class RacingCarGame {
    private Car car;
    private InputValidator inputValidator;
    private int[] count;

    public RacingCarGame() {
        inputValidator = new InputValidator();
    }

}

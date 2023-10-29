package racingcar.controller;

import racingcar.model.Cars;

public class RacingGame {
    private Cars cars;
    private int repeatNum;

    public void playRacingGame() {
        initRacingGameInput();
    }

    private void initRacingGameInput() {
        this.cars = CarCreator.createCars();
        this.repeatNum = RepeatNum.setRepeatNum();
    }
}

package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingGame {
    private static Cars cars;
    public void playRacingGame() {
        setCars();
    }

    private void setCars() {
        this.cars = CarCreator.createCars();
    }
}

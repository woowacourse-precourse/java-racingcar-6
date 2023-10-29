package racingcar.controller;

import racingcar.domain.CarGameManager;
import racingcar.domain.Cars;

public class CarGameController {

    private Cars cars;
    private int roundNumber;

    private CarGameManager carGameManager = new CarGameManager();

    public void set() {
        this.cars = carGameManager.carNamesSet();
        this.roundNumber = carGameManager.roundNumberSet();
    }

    public void start() {
        carGameManager.carGameStart(this.cars, this.roundNumber);
    }

    public void winner() {
        carGameManager.resultWinner(this.cars);
    }
}

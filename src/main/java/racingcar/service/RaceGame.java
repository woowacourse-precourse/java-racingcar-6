package racingcar.service;


import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.TryNumber;

public class RaceGame {
    private CarList carList;
    private TryNumber tryNumber;

    public RaceGame(String carNames) {
        carList = new CarList(carNames);
    }

    public void makeTryNumber(String tryNumber) {
        this.tryNumber = new TryNumber(tryNumber);
    }

    public String moveAllCars() {
        return carList.move();
    }

    public boolean isEnd(int currentTryNumber) {
        return tryNumber.getTryNumber() == currentTryNumber;
    }
}

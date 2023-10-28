package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    private RacingCars cars;
    private int tryCount;

    public RacingcarGame() {
        this.cars = new RacingCars();
        this.tryCount = 0;
    }

    public void setCars(String[] carsName) {
        cars.setRacingCars(carsName);
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}

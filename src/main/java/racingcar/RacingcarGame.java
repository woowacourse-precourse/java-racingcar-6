package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    private RacingCars cars;

    public RacingcarGame() {
    }

    public void setCars(String[] carsName) {
        cars.setRacingCars(carsName);
    }
}

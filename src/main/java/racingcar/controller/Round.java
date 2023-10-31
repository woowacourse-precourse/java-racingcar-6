package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;

public class Round {

    public void play(List<Car> carList) {
        createRandom(carList);
    }

    public void createRandom(List<Car> carList) {
        for (Car car : carList) {
            RandomNumber.make();
        }
    }

}

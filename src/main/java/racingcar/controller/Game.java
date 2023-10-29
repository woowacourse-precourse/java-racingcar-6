package racingcar.controller;

import static racingcar.view.InputView.askCarName;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Game {
    public void start() {
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(askCarName());
        for (Car car : carList) {
            System.out.println(car.getName());
        }
    }
}

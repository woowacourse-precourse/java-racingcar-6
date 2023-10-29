package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public List<Car> createCar(String[] carNames) {

        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playRacing(int tryCount,List<Car> cars) {
        for (int i=0; i<tryCount; i++) {
            moveCar(cars);
            OutputView.showCarNameAndPosition(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }
}
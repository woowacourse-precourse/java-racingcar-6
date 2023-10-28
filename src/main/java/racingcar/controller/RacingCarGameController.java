package racingcar.controller;


import static racingcar.util.RandomNumber.randomNumber;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.view.InputView;
public class RacingCarGameController {
    private final InputView inputView;
    private final List<Car> cars;


    public RacingCarGameController() {

        this.inputView = new InputView();
        this.cars = new ArrayList<>();
    }

    public void play() {

        List<String> carNames = inputView.getCarNames();

        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }

        int moveCount = inputView.getMoveCount();

        int index = 0;

        while (index < moveCount) {
            moveCarForward();
            index++;
        }

    }

    private void moveCarForward() {
        for (Car car : cars) {
            int randomNumber = randomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

}
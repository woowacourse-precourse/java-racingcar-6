package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Result;
import racingcar.view.InputView;

public class Controller {
    private final List<Car> cars;

    public Controller() {
        this.cars = new ArrayList<>();
    }

    public void play() {
        settingCarName();
        runGame();
        displayFinalResult();
    }

    private void displayFinalResult() {
        Result result = new Result(cars);
        System.out.println(result.getWinners());
    }

    private void runGame() {
        int attemptCount = InputView.inputAttemptCount();
        System.out.println("실행 결과");
        while (attemptCount-- > 0) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
        System.out.println();
        for (Car car : cars) {
            System.out.println(car.getRecord());
        }
    }

    private void settingCarName() {
        String[] carNames = InputView.inputCarName();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}

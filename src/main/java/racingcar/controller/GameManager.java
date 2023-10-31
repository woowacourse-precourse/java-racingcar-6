package racingcar.controller;

import static racingcar.service.JudgeResult.getWinners;
import static racingcar.util.RandomNumber.getRandomNumber;
import static racingcar.view.InitialInputs.readCarNames;
import static racingcar.view.InitialInputs.readExcecutionNumber;
import static racingcar.view.RacingProcess.showOneRound;
import static racingcar.view.RacingProcess.showText;
import static racingcar.view.Winners.showWinners;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GameManager {
    private List<Car> cars = new ArrayList<>();
    private int executionNumber;

    public void playGame() {
        set(readCarNames(), readExcecutionNumber());
        play();
        result();
    }

    void set(List<String> names, int readNumber) {
        names.stream().forEach(name -> cars.add(new Car(name)));
        executionNumber = readNumber;
    }

    void play() {
        showText();
        for (int i = 0; i < executionNumber; i++) {
            updateOneRound();
            showOneRound(cars);
        }
    }

    private void updateOneRound() {
        for (Car car : cars) {
            car.updateDistance(getRandomNumber());
        }
    }

    void result() {
        showWinners(getWinners(cars));
    }
}

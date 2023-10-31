package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Car> cars = new ArrayList<>();
    private int maxPosition = 0;

    public void setUp(String names) {
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public void run(int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            printRoundResult();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            ResultView.printCarPosition(car);
        }
        ResultView.printNewLine();
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}



package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = GameController.getCarNames();
        int totalRound = GameController.getTotalRound();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.create(name));
        }

        for (int i = 0; i < totalRound; i++) {
            GameController.playRound(cars, totalRound);
        }

    }
}

package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        OutputView.askCarNames();
        List<String> carNames = GameController.getCarNames();
        OutputView.askTotalRound();
        int totalRound = GameController.getTotalRound();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.create(name));
        }

        for (int i = 0; i < totalRound; i++) {
            GameController.playRound(cars, totalRound);
        }

        GameController.processResult(totalRound, carNames, cars);
    }
}

package racingcar.controller;

import racingcar.domain.Car;
import racingcar.utils.Validator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public static List<String> getCarNames() {
        String input = InputView.readFromUser();
        return Validator.validateCarNames(input);
    }

    public static int getTotalRound() {
        String input = InputView.readFromUser();
        return Validator.validateTotalRound(input);
    }

    public static void playRound(List<Car> cars, int totalRound) {
        for (Car car : cars) {
            car.play();
        }
    }
}

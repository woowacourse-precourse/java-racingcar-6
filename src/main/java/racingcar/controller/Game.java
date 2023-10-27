package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.view.constants.Notice.ASK_MULTIPLE_CAR_NAMES;

public class Game {
    public static void start() {
        OutputView.printStaticMessage(ASK_MULTIPLE_CAR_NAMES);
        String carNamesInput = InputView.playerInput();
        List<Car> carList = Car.createCarList();
    }
}

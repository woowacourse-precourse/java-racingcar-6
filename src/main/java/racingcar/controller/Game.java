package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        List<String> racingCarList = InputView.getRacingCars(); // [abc,def,ge]

        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber(); // 5

        OutputView.printShowResultString();
    }
}
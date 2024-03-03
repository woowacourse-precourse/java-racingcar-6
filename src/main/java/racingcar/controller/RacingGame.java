package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.*;
import racingcar.view.*;

public class RacingGame {
    private List<Car> carList;
    private int round;

    public RacingGame() {
        round = 0;
        carList = new ArrayList<>();
    }

    public void play() {
        initCarList();
        initTryCount();
        for (int i = 0; i < round; i++) {
            for (Car car : carList) {
                car.decideMove();
            }
            OutputView.printRoundResult(carList);
        }
        Referee referee = new Referee(carList);
        List<Car> winners = referee.judgeWinners();
        OutputView.printWinners(winners);
    }

    private void initCarList() {
        String[] carNames = InputView.inputCarNames().split(",");
        for (String carName : carNames) {
            try {
                Validator.validateSize(carName);
                carList.add(Car.createCar(carName));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void initTryCount() {
        try {
            round = InputView.inputTryCount();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}

package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final Cars cars;
    private int moveCount;

    public RacingController(Cars cars) {
        this.cars = cars;
    }

    public void init() {
        inputCarNames();
        inputMoveCount();
    }

    private void inputCarNames() {
        OutputView.printNameInputDescription();
        try {
            cars.createCars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void inputMoveCount() {
        OutputView.printMoveCountInputDescription();
        try {
            moveCount = InputView.inputMoveCount();
            validateCountRange(moveCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    private void validateCountRange(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 자연수여야 합니다.");
        }
    }

    public void play() {
        OutputView.printResultDescription();
        for (int i = 0; i < moveCount; i++) {
            cars.playRound();
            OutputView.printRoundStatus(cars.getAllCars());
        }
    }

    public void finish() {
        OutputView.printWinners(cars.getWinners());
    }
}

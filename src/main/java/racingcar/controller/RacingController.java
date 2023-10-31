package racingcar.controller;


import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final CarService carService;
    private int moveCount;

    public RacingController(CarService carService) {
        this.carService = carService;
    }

    public void init() {
        inputCarNames();
        inputMoveCount();
    }

    private void inputCarNames() {
        OutputView.printNameInputDescription();
        try {
            carService.createCars(InputView.inputCarNames());
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
            carService.playRound();
            OutputView.printRoundStatus(carService.getAllCars());
        }
    }

    public void finish() {
        OutputView.printWinners(carService.findWinners());
    }

}

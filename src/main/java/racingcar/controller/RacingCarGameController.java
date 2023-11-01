package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarManager carManager;


    public RacingCarGameController(InputView inputView, OutputView outputView, CarManager carManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carManager = carManager;
    }

    public void play() {

        String names = inputView.getCarNames();
        List<String> carNames = inputView.getSplitCarNames(names);
        List<Car> cars = carManager.initializeCars(carNames);
        int moveCount = inputView.getMoveCount();

        playGame(cars, moveCount);

        gameResult(cars);
    }

    private void gameResult(List<Car> cars) {
        List<Car> winners = carManager.findWinners(cars);
        outputView.printWinners(winners);
    }

    private void playGame(List<Car> cars, int moveCount) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {
            carManager.moveCarForward(cars);
            outputView.printPositions(cars);
        }
    }
}
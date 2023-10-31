package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarController carController;


    public RacingCarGameController(InputView inputView, OutputView outputView, CarController carController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carController = carController;
    }

    public void play() {

        String names = inputView.getCarNames();

        List<String> carNames = inputView.getSplitCarNames(names);

        List<Car> cars = carController.initializeCars(carNames);

        int moveCount = inputView.getMoveCount();

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {
            carController.moveCarForward(cars);
            outputView.printPositions(cars);

        }

        List<Car> winners = carController.findWinners(cars);
        outputView.printWinners(winners);
    }


}
package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> carNames = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();

        Cars cars = new Cars(carNames);

        outputView.printGameResult();
        for (int i = 0; i < tryCount; i++) {
            Map<Car, Integer> moveResults = cars.moveAllCars();
            outputView.printMoveResult(moveResults);
        }

        List<String> winner = cars.findWinner();
        outputView.printWinner(winner);
    }
}
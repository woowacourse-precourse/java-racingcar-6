package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = new Cars(inputView.readCarNames());
        int count = inputView.readTryCount();

        for (int i = 0; i < count; i++) {
            play(cars);
        }
        complete(cars);
    }

    private void play(Cars cars) {
        cars.moveCars();
        outputView.printResult(cars);
    }

    private void complete(Cars cars) {
        List<String> winners = cars.selectWinners();
        outputView.printWinners(winners);
    }
}

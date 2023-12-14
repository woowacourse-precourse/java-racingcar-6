package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.console.ConsoleWriter;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = retry(() -> {
            return new Cars(inputView.readCarNames());
        });
        int count = retry(() -> {
            return inputView.readTryCount();
        });

        for (int i = 0; i < count; i++) {
            play(cars);
        }
        complete();
    }

    private void play(Cars cars) {
        cars.moveCars();
        outputView.printResult(cars);
    }

    private void complete(Cars cars) {
        List<String> winners = cars.selectWinners();
        outputView.printWinners(winners);
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}

package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.console.ConsoleWriter;

public class GameManager {
    private final InputView inputView;

    public GameManager(InputView inputView) {
        this.inputView = inputView;
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
    }

    private void play(Cars cars) {
        cars.moveCars();
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

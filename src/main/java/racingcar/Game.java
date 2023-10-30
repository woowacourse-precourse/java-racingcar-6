package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.WinnerView;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;
import static racingcar.view.WinnerView.*;

public class Game {
    private final CarManager carManager;

    public Game() {
        this.carManager = new CarManager(new RandomNumberGenerator());
    }

    public void start() {
        String[] names = displayCarNamesInputView();
        carManager.createCars(names);

        Integer attempt = displayAttemptNumberInputView();
        displayEmptyLine();

        displayStaticOutView();

        for (int i = 0; i < attempt; i++) {
            carManager.moveCars();
            displayOutputView(carManager.getCars());
            displayEmptyLine();
        }

        displayWinnerView(carManager.getWinners());
    }

    private void displayEmptyLine() {
        System.out.print("\n");
    }
}

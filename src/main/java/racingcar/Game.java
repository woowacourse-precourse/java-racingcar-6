package racingcar;

import static racingcar.view.InputView.displayAttemptNumberInputView;
import static racingcar.view.InputView.displayCarNamesInputView;
import static racingcar.view.OutputView.displayOutputView;
import static racingcar.view.OutputView.displayStaticOutView;
import static racingcar.view.WinnerView.displayWinnerView;

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

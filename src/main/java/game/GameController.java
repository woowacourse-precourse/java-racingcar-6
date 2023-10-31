package game;

import car.Cars;
import console.InputView;
import console.OutputView;

public class GameController {
    private GameController() {
        throw new IllegalArgumentException();
    }

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void game(){
        outputView.printGameStart();
        String carNames = inputView.getCarNames();
        Cars cars = new Cars(carNames);
        outputView.printTrials();
        int rounds = inputView.getNumericInput();
        for (int i = 0; i < rounds; i++) {
            cars.move();
            outputView.printRoundResult(cars);
        }
        outputView.printWinners(cars);
    }
}

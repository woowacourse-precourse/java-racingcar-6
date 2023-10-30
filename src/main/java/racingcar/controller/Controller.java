package racingcar.controller;


import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameInitializer gameInitializer;
    private final GameRunner gameRunner;

    public Controller(InputView inputView, OutputView outputView, GameRunner gameRunner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameInitializer = new GameInitializer(inputView, outputView);
        this.gameRunner = gameRunner;
    }


    public void run() {
        Cars cars = gameInitializer.initializeCars();
        int rounds = gameInitializer.initializeRounds();
        gameRunner.runRounds(cars, rounds);
        outputView.announceWinner(cars.getWinners());
    }
}
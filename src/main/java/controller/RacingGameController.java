package controller;

import model.Cars;
import model.TryCount;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private Cars cars;
    private TryCount tryCount;
    public void start() {
        cars = new Cars(inputView.requestCarNames());
        tryCount = new TryCount(inputView.requestTryCount());
        gameRun();
        outputView.printWinner(cars.getWinners());
    }

    private void gameRun() {
        outputView.printResult();
        for (int i = 0; i < tryCount.getCount(); i++) {
            cars.allTryMove();
            outputView.printCarsPosition(cars.getCars());
        }
    }
}

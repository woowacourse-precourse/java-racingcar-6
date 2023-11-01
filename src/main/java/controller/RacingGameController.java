package controller;

import model.Cars;
import model.TryCount;
import model.Winners;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Cars cars = new Cars(inputView.requestCarNames());
        TryCount tryCount = inputView.requestTryCount();
        outputView.printResult();

        for (int i = 0; i < tryCount.getCount(); i++) {
            cars.allTryMove();
            outputView.printCarsPosition(cars);
        }

        outputView.printWinner(new Winners(cars.getCars()));

    }
}

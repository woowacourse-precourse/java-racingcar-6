package controller;

import model.Cars;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Cars cars = new Cars(inputView.requestCarNames());
        int tryCount = inputView.requestTryCount();

        outputView.printResult();
        for(int i=0; i<tryCount; i++){
            cars.allTryMove();
            outputView.printCarsPosition(cars);
        }
        outputView.printWinner(cars);

    }
}

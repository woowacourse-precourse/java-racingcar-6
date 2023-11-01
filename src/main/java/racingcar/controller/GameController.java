package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.NumberGenerator;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class GameController {

    public void run() {
        String carNames = GameInputView.getUserCarNames();
        Cars cars = new Cars(carNames);
        int totalRoundNumber = GameInputView.getTotalRoundNumber();

        GameOutputView.printResultsHeader();
        for (int i=0; i<totalRoundNumber; i++) {
            cars.race(NumberGenerator.generateRandomNumbers(cars.size()));
            GameOutputView.printCarPositions(cars.getPositions());
        }

        GameOutputView.printWinner(cars.getWinners());
    }
}
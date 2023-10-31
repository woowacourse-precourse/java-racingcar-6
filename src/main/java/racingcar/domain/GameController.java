package racingcar.domain;

import java.util.List;

public class GameController {
    public void playGame() {
        InputCarName inputCarName = new InputCarName();
        InputNumberOfAttempts inputNumberOfAttempts = new InputNumberOfAttempts();
        List<String> carNames = inputCarName.getCarNames();
        int numberOfAttempts = inputNumberOfAttempts.getNumberOfAttempts();

        MoveController moveController = new MoveController();
        RaceResultsPresenter raceResultsPresenter = new RaceResultsPresenter();
        do {
            moveController.move(carNames);
            raceResultsPresenter.printRaceProcess();
        }
        while (numberOfAttempts-- != 0);
        
        raceResultsPresenter.printWinner();
    }
}

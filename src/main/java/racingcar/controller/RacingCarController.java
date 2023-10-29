package racingcar.controller;

import racingcar.domain.GameInfo;
import racingcar.domain.RacingCar;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private GameInfo gameInfo;

    public void start() {
        gameInfo = RacingCarView.gameStart();
        playGame();
        printWinner();
    }

    private void printWinner() {
        gameInfo.printWinner();
    }

    private void playGame() {
        RacingCarView.printResult();
        int gameRound = gameInfo.getCount();
        for (int i = 0; i < gameRound; i++) {
            gameInfo.getCarList().forEach(RacingCar::go);
            RacingCarView.printBlank();
        }
    }

}

package racingcar.controller;

import racingcar.constant.Constant;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public RacingCarGameController() {
        InputView.printStartMessage();
    }

    public void getNumberOfGameRepeat () {
        int NumberOfGameRepeat = InputView.checkAttemptsNumber();
        System.out.println();
        OutputView.printResultOfTheGame();
        for(int i = 0; i < NumberOfGameRepeat; i ++) {
            Referee.compare(Constant.BASE_NUMBER);
            if (i != NumberOfGameRepeat - 1) {
                OutputView.gameResult();
            }
        }
    }

    public void CarRacingGameProcess() {
        InputView.checkInputRacingCarName();
        getNumberOfGameRepeat();
        OutputView.gameResult();
        OutputView.winnerOfGame();
    }
}

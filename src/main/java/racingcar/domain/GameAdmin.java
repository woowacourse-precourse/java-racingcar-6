package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameAdmin {
    ResultView resultView = new ResultView();
    public void startGame(Cars cars) {
        Round round = Round.getRound(InputView.inputRound());
        resultView.printShowResult();
        for (int i = 0; i < round.getRound(); i++) {
            cars.startRace();
            resultView.showRoundResult(cars);
        }
    }
    public void presentWinner(Cars cars) {
        Winners winners = Winners.from(cars);
        resultView.callWinner(winners.getWinnerName());
    }
}

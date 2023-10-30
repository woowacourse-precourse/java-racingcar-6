package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameAdmin {
    private final ResultView resultView;

    private GameAdmin(ResultView resultView) {
        this.resultView = resultView;
    }

    public static GameAdmin from(ResultView resultView) {
        return new GameAdmin(resultView);
    }

    public void startGame(Cars cars, MovableStrategy movableStrategy) {
        Round round = Round.getRound(InputView.inputRound());
        resultView.printShowResult();
        for (int i = 0; i < round.getRound(); i++) {
            cars.startRace(movableStrategy);
            resultView.showRoundResult(cars);
        }
    }

    public void presentWinner(Cars cars) {
        Winners winners = Winners.from(cars);
        resultView.callWinner(winners.getWinnerName());
    }
}

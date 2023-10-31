package racingcar.domain;

import racingcar.view.ResultView;

public class GameAdmin {
    private final Round round;

    private GameAdmin(Round round) {
        this.round = round;
    }

    public static GameAdmin from(Round round) {
        return new GameAdmin(round);
    }

    public void startGame(Cars cars, MovableStrategy movableStrategy) {
        ResultView.printShowResult();
        for (int i = 0; i < round.getRound(); i++) {
            cars.startRace(movableStrategy);
            ResultView.showRoundResult(cars);
        }
    }

    public void presentWinner(Cars cars) {
        Winners winners = Winners.from(cars);
        ResultView.callWinner(winners.getWinnerName());
    }
}
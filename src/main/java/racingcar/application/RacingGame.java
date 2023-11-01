package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.GameAdmin;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.Round;
import racingcar.view.InputView;

public class RacingGame {
    public void race() {
        Cars cars = Cars.from(InputView.inputCarName());
        Round round = Round.from(InputView.inputRound());
        GameAdmin gameAdmin = GameAdmin.from(round);
        gameAdmin.startGame(cars, new RandomMoveStrategy());
        gameAdmin.presentWinner(cars);
    }
}

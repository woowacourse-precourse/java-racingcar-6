package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.GameAdmin;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public void race() {
        Cars cars = Cars.from(InputView.inputCarName());
        ResultView resultView = new ResultView();
        GameAdmin gameAdmin = GameAdmin.from(resultView);
        gameAdmin.startGame(cars, RandomMoveStrategy.createStrategy());
        gameAdmin.presentWinner(cars);
    }
}

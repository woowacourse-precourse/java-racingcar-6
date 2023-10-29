package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.GameAdmin;
import racingcar.view.InputView;

public class RacingGame {
    public void race() {
        Cars cars = Cars.from(InputView.inputCarName());
        GameAdmin gameAdmin = new GameAdmin();
        gameAdmin.startGame(cars);
        gameAdmin.presentWinner(cars);
    }
}

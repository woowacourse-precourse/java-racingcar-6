package racingcar;

import racingcar.view.InputView;

public class GameController {
    public void start() {
        String[] carNames = InputView.startGameCommand();
        int tryCount = InputView.getTryCount();
        RacingGame racingGame = new RacingGame(carNames, tryCount);
    }
}

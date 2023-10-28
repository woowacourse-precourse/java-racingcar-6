package racingcar;

import racingcar.view.InputView;

public class GameController {
    public void start() {
        String[] carNames = InputView.startGameCommand();
        RacingGame racingGame = new RacingGame(carNames);

    }
}

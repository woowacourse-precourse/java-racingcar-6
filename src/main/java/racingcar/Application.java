package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame(InputView.takeCarNames());
        racingGame.start(InputView.takeTryNumber());
        racingGame.finish();
    }
}

package racingcar;

import racingcar.actionnumber.RandomActionNumberGenerator;
import racingcar.game.RacingCarGame;
import racingcar.view.RacingGameConsoleView;

public class Application {
    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(
                new RacingGameConsoleView(),
                new RandomActionNumberGenerator());
        game.play();
    }
}

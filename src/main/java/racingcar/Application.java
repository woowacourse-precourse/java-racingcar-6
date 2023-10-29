package racingcar;

import racingcar.controller.PlayerControllerImpl;
import racingcar.logic.Game;
import racingcar.logic.RacingGame;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new RacingGame(new PlayerControllerImpl(), new ConsoleView());
        game.run();
    }
}

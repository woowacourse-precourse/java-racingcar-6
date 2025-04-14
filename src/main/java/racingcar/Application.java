package racingcar;

import racingcar.commponent.Game;
import racingcar.commponent.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = RacingGame.getInstance();
        game.play();
    }
}

package racingcar;

import racingcar.Controller.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame game = new RacingGame();
        game.input();
        game.run();
    }
}

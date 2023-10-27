package racingcar;

import racingcar.game.RacingGame;
import racingcar.io.Output;

public class Application {

    public static void main(String[] args) {
        try {
            RacingGame racingGame = new RacingGame();
            racingGame.play();
        } catch (IllegalArgumentException e) {
            Output.consoleLine("잘못된 동작으로 인해 프로그램을 종료합니다.");
            throw e;
        }
    }

}

package racingcar;

import racingcar.constant.Constant;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(Constant.INITIAL_LIST);
        racingGame.startRacing();
    }
}

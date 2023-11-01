package racingcar;

import model.RoundSet;
import service.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();

        RoundSet roundSet = racingGame.gameStart();

        racingGame.gameProcess(roundSet);

    }
}

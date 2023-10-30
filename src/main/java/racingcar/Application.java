package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.newRacingGame();
        racingGame.play();
        Console.close();
    }
}

package racingcar;

import racingcar.controller.GameManager;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        GameManager racingcarGame = new GameManager(numberGenerator);
        racingcarGame.runGame();
    }
}

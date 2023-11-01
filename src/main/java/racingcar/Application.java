package racingcar;

import racingcar.service.RacingGame;

import static racingcar.service.Initializer.*;

public class Application {
    public static void main(String[] args) {
        new RacingGame(initializeCars(), initializeTryCount()).play();
    }
}

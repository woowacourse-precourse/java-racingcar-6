package racingcar;

import racingcar.impl.RacingGame;
import racingcar.impl.RandomNumberProviderImpl;
import racingcar.impl.UserInputImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game racingGame = new RacingGame(new UserInputImpl(), new RandomNumberProviderImpl());
        racingGame.start();
    }
}

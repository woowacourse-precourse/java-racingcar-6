package racingcar;

import racingcar.impl.RacingGame;
import racingcar.impl.RandomNumberProviderImpl;
import racingcar.impl.UserInputImpl;
import racingcar.util.GameSetting;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameSetting gameSetting = new GameSetting(new UserInputImpl());
        Game racingGame = new RacingGame(new RandomNumberProviderImpl());
        racingGame.start(gameSetting.createGameInfo());
        racingGame.getResult();
    }
}

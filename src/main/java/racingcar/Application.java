package racingcar;

import racingcar.Type.GameType;
import racingcar.impl.RacingGame;
import racingcar.impl.RandomNumberProviderImpl;
import racingcar.impl.UserInputImpl;
import racingcar.util.GameFactory;
import racingcar.util.GameSetting;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory(List.of(new RacingGame(new RandomNumberProviderImpl())));

        GameSetting gameSetting = new GameSetting(new UserInputImpl());

        Game racingGame = gameFactory.getGame(GameType.Racing);
        racingGame.start(gameSetting.createGameInfo());
        racingGame.getResult();
    }
}

package racingcar.common;

import racingcar.service.GameService;

public class GameServiceFactory {
    public static GameService createGameService() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
        return new GameService(randomNumberGenerator);
    }
}

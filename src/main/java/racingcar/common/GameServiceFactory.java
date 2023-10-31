package racingcar.common;

import racingcar.service.GameService;

public class GameServiceFactory {
    private GameServiceFactory() {
        
    }

    public static GameService createGameService() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
        return new GameService(randomNumberGenerator);
    }
}

package racingcar.config;

import racingcar.domain.RacingCarGame;

public class RacingCarGameFactory {
    private static RacingCarGame racingCarGame;

    private RacingCarGameFactory() {
    }

    public static RacingCarGame createSingletonRacingCarGame() {
        if (racingCarGame == null) {
            racingCarGame = RacingCarGame.of(ConsoleFactory.createSingletonConsole(), RaceFactory.createSingletonRace());
        }
        return racingCarGame;
    }

}

package racingcar.service;

import racingcar.domain.RacingGame;

public class GameService {

    public static void playSingleRound(RacingGame racingGame) {
        while (!racingGame.isFinalRound()) {
            racingGame.nextRound();
            racingGame.getCars().forEach(CarService::goByPickRandomNumber);
        }
    }
}

package racingcar.service;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDtos;

public class GameService {
    private Game game;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameService(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void initializeGame(final String carNames,final String tryCount) {
        this.game = new Game(carNames, tryCount,this.randomNumberGenerator);
    }

    public boolean isGameFinished() {
        return game.isFinished();
    }

    public void playRound() {
        game.playRound();
    }

    public CarDtos getCarPositions() {
        return game.createCarDtos();
    }

}

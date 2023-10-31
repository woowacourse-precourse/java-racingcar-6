package racingcar.service;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDtos;
import racingcar.domain.dto.WinnersDto;

public class GameService {
    private Game game;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameService(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void initializeGame(final String carNames,final String tryCount) {
        this.game = new Game(carNames, tryCount,this.randomNumberGenerator);
    }

    public WinnersDto getWinners() {
        return this.game.createWinnersDto();
    }

    public boolean isGameFinished() {
        return this.game.isFinished();
    }

    public void playRound() {
        this.game.playRound();
    }

    public CarDtos getCarPositions() {
        return this.game.createCarDtos();
    }

}

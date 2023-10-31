package racingcar.service;

import racingcar.domain.Game;
import racingcar.validator.RoundCountValidator;

public class GameService {

    public int initGameRound(String inputRound) {
        RoundCountValidator roundCountValidator = new RoundCountValidator();
        roundCountValidator.validateInputGameRound(inputRound);

        return Integer.parseInt(inputRound);
    }

    public Game setGame(int carCount, int round) {
        return new Game(carCount, round);
    }

}

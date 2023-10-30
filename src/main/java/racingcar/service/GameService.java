package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.validator.RoundCountValidator;

public class GameService {

    public int initGameRound(String inputRound) {
        int round = 0;
        RoundCountValidator roundCountValidator = new RoundCountValidator();
        if(roundCountValidator.validateInputGameRound(inputRound)) {
            round = Integer.parseInt(inputRound);
        }
        return round;
    }

    public Game setGame(int carCount, int round) {
        return new Game(carCount, round);
    }

}

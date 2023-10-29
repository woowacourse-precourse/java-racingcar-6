package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.BuilderUtils;
import racingcar.validator.RoundCountValidator;

import java.util.Locale;


public class GameService {

    private Game game;
    private Car car;
    public int initGameRound(String inputRound) {
        int round = 0;
        RoundCountValidator roundCountValidator = new RoundCountValidator();
        if(roundCountValidator.validateInputGameRound(inputRound)) {
            round = Integer.parseInt(inputRound);
        }
        return round;
    }

    public void initGame(int carCount, int round) {
        game = new Game(carCount, round);
    }

    public int setGameRound() {
        return game.getRoundCount();

    }
}

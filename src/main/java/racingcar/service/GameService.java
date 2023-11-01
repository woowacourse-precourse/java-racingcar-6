package racingcar.service;

import static racingcar.domain.Game.DISTANCE_TO_MOVE;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.util.RandomNumberGeneratorUtil;

public class GameService {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_TRIGGER = 4;

    private final RacingCarService racingCarService = new RacingCarService();

    public Game createGame(List<String> racingCarNames, int totalAttempts) {
        RacingCars racingCars = racingCarService.createRacingCars(racingCarNames);
        return new Game(racingCars, totalAttempts);
    }

    public void playSingleRound(Game game) {
        game.increaseAttempts();
        moveCars(game.getRacingCarList());
    }

    private void moveCars(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            if (checkIsForwarding()) {
                racingCar.updatePosition(DISTANCE_TO_MOVE);
            }
        }
    }

    private boolean checkIsForwarding() {
        int randomNumber = RandomNumberGeneratorUtil.generate(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return randomNumber >= FORWARD_TRIGGER;
    }

}

package racingcar.domain;

import static racingcar.constant.RacingGameConstant.ATTEMPT_NUMBER;
import static racingcar.constant.RacingGameConstant.RANDOM_NUMBER_END_INCLUSIVE;
import static racingcar.constant.RacingGameConstant.RANDOM_NUMBER_START_INCLUSIVE;

import java.util.List;
import racingcar.domain.random.RandomNumberFactory;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;

public class RacingGame {
    private final RandomNumberFactory randomNumberFactory;

    public RacingGame(RandomNumberFactory randomNumberFactory) {
        this.randomNumberFactory = randomNumberFactory;
    }

    public RacingGameRs startGame(RacingGameRq racingGameRq) {
        List<RacingCar> racingCars = racingGameRq.toRacingCars();
        move(racingCars);
        return RacingGameRs.toRacingGameRs(racingCars, leftNumberOfAttempts(racingGameRq));
    }

    private void move(List<RacingCar> cars) {
        cars.forEach(racingCar -> {
            racingCar.race(randomNumberFactory.create(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE));
        });
    }

    private long leftNumberOfAttempts(RacingGameRq racingGameRq) {
        return racingGameRq.getLeftNumberOfAttempts() - ATTEMPT_NUMBER;
    }
}

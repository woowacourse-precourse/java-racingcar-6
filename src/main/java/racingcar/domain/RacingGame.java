package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.condition.MoveCondition;
import racingcar.domain.random.RandomNumberFactory;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;

public class RacingGame {

    public static final int ATTEMPT_NUMBER = 1;
    private final RandomNumberFactory randomNumberFactory;

    public RacingGame(RandomNumberFactory randomNumberFactory) {
        this.randomNumberFactory = randomNumberFactory;
    }

    public RacingGameRs startGame(RacingGameRq racingGameRq) {
        List<RacingCar> racingCars = new ArrayList<>();
        racingGameRq.getRacingCarDtoList().stream()
                .map(racingCarDto -> new RacingCar(racingCarDto.getCarName(), racingCarDto.getPosition(),
                        new MoveCondition())).forEachOrdered(racingCar -> {
                    racingCar.race(randomNumberFactory.create(0, 9));
                    racingCars.add(racingCar);
                });
        return RacingGameRs.createRacingGameRs(racingCars, leftNumberOfAttempts(racingGameRq));
    }

    private long leftNumberOfAttempts(RacingGameRq racingGameRq) {
        return racingGameRq.getLeftNumberOfAttempts() - ATTEMPT_NUMBER;
    }
}

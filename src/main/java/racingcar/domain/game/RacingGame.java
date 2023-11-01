package racingcar.domain.game;

import racingcar.domain.car.CarDto;
import racingcar.domain.car.Cars;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Rounds rounds;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<List<CarDto>> logs;

    public RacingGame(Cars cars, Rounds rounds, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.rounds = rounds;
        this.randomNumberGenerator = randomNumberGenerator;
        logs = new ArrayList<>();
    }

    public void race() {
        rounds.next();
        cars.race(randomNumberGenerator);
        this.recordLog();
    }

    private void recordLog() {
        List<CarDto> status = cars.getStatus();
        logs.add(status);
    }

    public boolean isEnd() {
        return rounds.isEnd();
    }

    public GameResultDto getResult() {
        List<String> winners = cars.findTopCarNames();
        return new GameResultDto(logs, winners);
    }
}

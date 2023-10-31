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
        this.rounds.next();
        this.cars.race(randomNumberGenerator);
        this.recordLog();
    }

    private void recordLog() {
        List<CarDto> status = this.cars.getStatus();
        this.logs.add(status);
    }

    public boolean isEnd() {
        return this.rounds.isEnd();
    }

    public GameResultDto getResult() {
        List<String> winners = this.cars.findTopCarNames();
        return new GameResultDto(this.logs, winners);
    }
}

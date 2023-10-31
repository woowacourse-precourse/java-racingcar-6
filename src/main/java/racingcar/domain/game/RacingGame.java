package racingcar.domain.game;

import racingcar.domain.car.CarDto;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Rounds rounds;
    private final List<List<CarDto>> logs;

    public RacingGame(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
        logs = new ArrayList<>();
    }

    public void race() {
        this.rounds.next();
        this.cars.race();
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

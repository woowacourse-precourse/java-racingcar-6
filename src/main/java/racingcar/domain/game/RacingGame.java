package racingcar.domain.game;

import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Rounds rounds;
    private final List<String> logs;

    public RacingGame(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.logs = new ArrayList<>();
    }

    public void race() {
        this.rounds.next();
        this.cars.race();
        this.recordLog();
    }

    public void recordLog() {
        String log = this.cars.getStatus();
        this.logs.add(log);
    }

    public ResultDTO getResult() {
        List<String> winners = cars.findTopCars();
        return new ResultDTO(logs, winners);
    }

    public boolean isEnd() {
        return rounds.isEnd();
    }
}

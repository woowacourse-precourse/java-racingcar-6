package racingcar.games.racing.service;

import java.util.List;
import racingcar.games.racing.domain.Car;
import racingcar.games.racing.util.RacingProcessor;

public class RacingService {
    private static List<Car> cars;
    private final RacingProcessor racingProcessor;

    public RacingService(RacingProcessor racingProcessor) {
        this.racingProcessor = racingProcessor;
    }

    public void move(){
        racingProcessor.moveProcess(cars);
    }
}

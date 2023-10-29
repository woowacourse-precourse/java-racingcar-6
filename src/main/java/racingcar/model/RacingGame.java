package racingcar.model;

import java.util.List;

public class RacingGame {
    private final CarGroup cars;
    private final TryCount count;

    public RacingGame(List<String> names, Integer count) {
        this.cars = new CarGroup(names);
        this.count = new TryCount(count);
    }
}

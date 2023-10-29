package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private final CarGroup cars;
    private final TryCount count;

    public RacingGame(List<String> names, Integer count) {
        this.cars = new CarGroup(names, new RandomNumberGenerator());
        this.count = new TryCount(count);
    }

    public boolean isPlayable() {
        return count.isAbleTry();
    }
}

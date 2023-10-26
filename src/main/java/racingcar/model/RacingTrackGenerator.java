package racingcar.model;

import java.util.List;

public interface RacingTrackGenerator<T extends Vehicle> {

    RacingGame create(List<T> vehicles, int playCount);
}

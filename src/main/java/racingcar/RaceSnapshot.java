package racingcar;

import java.util.List;

public record RaceSnapshot(int race, List<CarSnapshot> cars) {
}

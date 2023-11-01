package racingcar;

import java.util.List;

public record GameResult(List<RaceSnapshot> history, List<CarSnapshot> winners) {
}

package racingcar;

import java.util.List;

public record GameResult(List<Game> history, List<Car> winners) {
}

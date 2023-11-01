package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;

public record MoveResults(List<MoveResult> results) {

    public static MoveResults from(final Cars cars) {
        return new MoveResults(cars.cars()
                .stream()
                .map(MoveResult::createResultFrom)
                .toList());
    }

    @Override
    public String toString() {
        return results.stream()
                .map(MoveResult::toString)
                .collect(Collectors.joining());
    }
}

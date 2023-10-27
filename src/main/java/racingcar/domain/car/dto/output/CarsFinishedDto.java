package racingcar.domain.car.dto.output;

import java.util.List;

public record CarsFinishedDto(
        List<String> winnerNames
) {
}

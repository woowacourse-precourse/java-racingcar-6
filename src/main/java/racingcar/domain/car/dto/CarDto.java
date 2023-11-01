package racingcar.domain.car.dto;

import racingcar.domain.car.wrapper.Name;
import racingcar.domain.car.wrapper.Position;

public record CarDto(
        Name name,
        Position position
) {

}

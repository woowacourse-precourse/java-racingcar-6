package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record CarGroupDto(
    List<Car> carGroup
) {

}

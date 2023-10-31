package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record CarsDTO(List<Car> cars) {
}

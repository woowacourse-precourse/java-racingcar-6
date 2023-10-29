package racingcar.dto;

import java.util.List;
import racingcar.model.Car;

public record CarsDto(List<Car> cars) {
}

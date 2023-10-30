package racingcar.domain.dto.output;

import racingcar.domain.Car;

import java.util.List;

public record CarsDto(List<Car> carList) {
}

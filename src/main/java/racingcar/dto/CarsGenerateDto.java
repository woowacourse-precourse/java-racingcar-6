package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record CarsGenerateDto(List<Car> cars, String[] carsName) {
}

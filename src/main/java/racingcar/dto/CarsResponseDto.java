package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record CarsResponseDto(List<Car> cars) {

    public static CarsResponseDto createCarsResponseDto(List<Car> updateCars) {
        return new CarsResponseDto(updateCars);
    }
}

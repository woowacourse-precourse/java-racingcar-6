package racingcar.dto;

import java.util.List;
import racingcar.domain.Cars;

public record CarsDto(List<CarDto> carDtos) {

    public static CarsDto of(final Cars cars) {

        return new CarsDto(cars.getCars()
                .stream()
                .map(CarDto::from)
                .toList());
    }

}

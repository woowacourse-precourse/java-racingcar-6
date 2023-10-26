package racingcar.dto;

import java.util.List;
import racingcar.domain.Cars;

public class CarsDto {

    private List<CarDto> carDtos;

    public CarsDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static CarsDto of(final Cars cars) {

        return new CarsDto(cars.getCars()
                .stream()
                .map(CarDto::of)
                .toList());
    }

    public List<CarDto> getCarDtoList() {
        return carDtos;
    }
}

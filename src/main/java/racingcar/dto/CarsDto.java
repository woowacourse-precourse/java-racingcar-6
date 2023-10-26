package racingcar.dto;

import java.util.List;
import racingcar.domain.Cars;

public class CarsDto {

    private List<CarDto> carDtos;

    public static CarsDto of(final Cars cars) {
        CarsDto carsDto = new CarsDto();
        carsDto.carDtos = cars.getCars()
                .stream()
                .map(CarDto::of)
                .toList();

        return carsDto;
    }

    public List<CarDto> getCarDtoList() {
        return carDtos;
    }
}

package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public record RoundResult(CarsDto carsDto) {

    public static RoundResult from(Cars cars) {
        return new RoundResult(CarsDto.from(cars));
    }

    public record CarsDto(List<CarDto> carDtos) {

        private static CarsDto from(Cars cars) {
            return new CarsDto(cars.getCars().stream()
                    .map(CarDto::from)
                    .toList());
        }
    }

    public record CarDto(String name, int position) {

        private static CarDto from(Car car) {
            return new CarDto(car.getName(), car.getPosition());
        }
    }
}

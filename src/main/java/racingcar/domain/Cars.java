package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.dto.CarInformationDto;
import racingcar.dto.CarsInformationDto;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public CarsInformationDto getInformation() {
        List<CarInformationDto> carInformationDtoList = cars.stream()
                .map(car -> car.getInformation())
                .toList();
        return new CarsInformationDto(carInformationDtoList);
    }

    public void move() {
        cars.forEach(Car::move);
    }

}

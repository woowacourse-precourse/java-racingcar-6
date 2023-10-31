package racingcar.domain;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarDtos;
import racingcar.domain.dto.WinnersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Cars {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Car> cars;

    public Cars(final String carNames, final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator=randomNumberGenerator;
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(final String carNames) {
        String[] names = carNames.split(",");

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name.trim(), this.randomNumberGenerator));
        }
        return carList;
    }

    public CarDtos toCarDtos() {
        List<CarDto> carDtoList = this.cars.stream()
                .map(Car::toCarDto)
                .toList();
        return new CarDtos(carDtoList);
    }

    public WinnersDto toWinnersDto() {
        int maxPosition = findMaxPosition();
        List<String> winnersDto = this.cars.stream()
                .filter(car -> car.createPositionDto().position() == maxPosition)
                .map(Car::toCarDto)
                .map(CarDto::name)
                .toList();
        return new WinnersDto(winnersDto);
    }

    private int findMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.createPositionDto().position())
                .max()
                .orElse(0);
    }

    public void forEach(Consumer<Car> action) {
        for (Car car : this.cars) {
            action.accept(car);
        }
    }
}

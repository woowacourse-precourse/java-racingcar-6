package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class Cars {

    private static final String NAME_DELIMITER = ",";
    private static final String SIZE_ERROR_MESSAGE = "자동차는 1대 이상이여야 합니다.";
    private static final String NO_CAR_ERROR_MESSAGE = "자동차가 존재하지 않습니다.";

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;


    public Cars(final String names) {
        validateSize(names);
        this.cars = new ArrayList<>(convertToCars(names));
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    private void validateSize(final String names) {
        if (names.split(NAME_DELIMITER).length == 0) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private List<Car> convertToCars(final String names) {
        return Arrays.stream(names.split(NAME_DELIMITER))
                .map(Car::new)
                .toList();
    }

    public void moveEachCar() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }

    public List<String> findWinnersName() {
        Car winner = findWinner();
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .toList();
    }

    private Car findWinner() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(NO_CAR_ERROR_MESSAGE);
                });
    }

    public CarsDto toCarsDto() {
        return new CarsDto(getCarDtos());
    }

    private List<CarDto> getCarDtos() {
        return cars.stream()
                .map(Car::toCarDto)
                .toList();
    }

}

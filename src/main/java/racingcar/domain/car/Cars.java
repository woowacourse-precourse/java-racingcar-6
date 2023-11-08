package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.car.validator.CarNamesValidator;
import racingcar.dto.CarDto;
import racingcar.utils.RandomNumber;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final RandomNumber randomNumber;

    public Cars(final List<String> names, final RandomNumber randomNumber) {
        CarNamesValidator.validateCarNames(names);
        names.forEach(name -> cars.add(new Car(name)));
        this.randomNumber = randomNumber;
    }

    public List<CarDto> getCarStatus() {
        return cars.stream()
                .map(this::convertToDto)
                .toList();
    }

    private CarDto convertToDto(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public void checkCarIsMovable() {
        cars.forEach(car -> car.moveForward(randomNumber));
    }

    public List<String> getGameWinner() {
        final int longestPosition = getLongestPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(longestPosition))
                .map(Car::getName)
                .toList();
    }

    private int getLongestPosition() {
        return Collections.max(this.getCurrentPosition());
    }

    private List<Integer> getCurrentPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}

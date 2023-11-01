package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.CarDto;
import racingcar.utils.Util;

public class Cars {

    private static final int DEFAULT_POSITION_VALUE = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        cars.forEach(car -> car.move(getRandomMovement()));
    }
    public List<CarDto> getCarDtos() {
        return Util.carsToCarDtos(Collections.unmodifiableList(cars));
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return getWinners(maxPosition);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION_VALUE);
    }

    private List<Car> getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private Movement getRandomMovement() {
        int randomNumber = Util.getRandomNumber();
        return Movement.from(randomNumber);
    }
}
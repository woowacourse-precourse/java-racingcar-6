package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DUPLICATE_NAME = "자동차의 이름은 중복될 수 없습니다.";
    private static final int DEFAULT_POSITION_VALUE = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            Movement movement = getRandomMovement();
            car.move(movement);
        }
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

    private void validateDuplicateCarName(List<Car> cars) {
        long uniqueCarCount = countUniqueCarName(cars);
        int originalCarCount = cars.size();

        if (uniqueCarCount != originalCarCount) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    private long countUniqueCarName(List<Car> cars) {
        return cars.stream()
                .map(Car::toString)
                .distinct()
                .count();
    }
}
package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();
    private final static int MAX_CAR_COUNT = 100;
    private final static String DUPLICATE_NAME_MESSAGE = "같은 이름의 자동차 이름이 존재합니다.";

    public void save(Car car) {
        validateDuplicateName(car.getName());
        this.cars.add(car);
    }

    private void validateDuplicateName(String carName) {
        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }
    }

    public List<CarDto> getCarDto() {
        return cars.stream()
                .map(car -> new CarDto(car))
                .toList();
    }

    public List<String> getWinner() {
        int max = getMaxPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}

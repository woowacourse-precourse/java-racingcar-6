package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.response.RaceResultResponse;

public class Cars {

    private final int CARS_INPUT_CRITERION = 2;
    private final List<Car> cars;

    public Cars(Names names) {
        validateCarsSize(names);
        this.cars = names.toCarList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveAllCars() {
        cars.forEach(car -> car.moveForward(RandomNumber.generateRandomNumber()));
    }

    public int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("Car 리스트가 존재하지 않습니다"));
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public void validateCarsSize(Names names) {
        if (names.getNames().size() < CARS_INPUT_CRITERION) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    public RaceResultResponse toResponse() {
        RaceResultResponse response = new RaceResultResponse();
        cars.forEach(response::updateCarPosition);
        return response;
    }
}

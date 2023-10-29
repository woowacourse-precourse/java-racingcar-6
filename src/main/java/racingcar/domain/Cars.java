package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCar(cars);
        this.cars = cars;
    }

    public static Cars from(List<String> cars) {
        return new Cars(cars.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> addWinners(winners, car));
        return winners;
    }

    private void addWinners(List<String> winners, Car car) {
        if (isSameMaxPosition(car)) {
            winners.add(car.getName());
        }
    }

    private boolean isSameMaxPosition(Car car) {
        return car.isSamePosition(calculateMaxPosition());
    }

    private int calculateMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxPosition = car.comparePosition(maxPosition);
        }
        return maxPosition;
    }

    private void validateDuplicateCar(List<Car> cars) {
        if (isDuplicateCar(cars)) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    private boolean isDuplicateCar(List<Car> cars) {
        long distinctCount = cars.stream()
                .distinct()
                .count();
        return distinctCount != cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}

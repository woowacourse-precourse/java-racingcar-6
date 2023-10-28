package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
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
        for (Car car : cars) {
            addWinners(winners, car);
        }
        return winners;
    }

    private void addWinners(List<String> winners, Car car) {
        if (isSamePosition(car)) {
            winners.add(car.getName());
        }
    }

    private boolean isSamePosition(Car car) {
        return car.getPosition() == calculateMaxPosition();
    }

    private int calculateMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}

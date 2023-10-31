package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Generator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    private void validate(List<Car> cars) {
        if (isEmptyOrNoCompetitors(cars)) {
            throw new IllegalArgumentException("자동차를 2대 이상 입력해야 합니다.");
        }
    }

    private boolean isEmptyOrNoCompetitors(List<Car> cars) {
        return cars.isEmpty() || cars.size() == 1;
    }


    public List<Car> getCars() {
        return cars;
    }

    public Cars simulateNextRound(Generator generator) {
        return new Cars(
                cars.stream()
                        .map(car -> car.move(generator.getNumber()))
                        .collect(Collectors.toList())
        );
    }

    public List<String> getWinners() {
        Car farthestCar = getFarthestCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(farthestCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getFarthestCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElse(null);
    }
}

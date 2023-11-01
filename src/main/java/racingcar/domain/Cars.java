package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        if (hasDuplicatedNames(cars)) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
        if (hasTooManyParticipants(cars)) {
            throw new IllegalArgumentException("참여자가 너무 많습니다.");
        }
    }

    private boolean hasTooManyParticipants(List<Car> cars) {
        final int MAXIMUM_PARTICIPANTS = 1000;
        return MAXIMUM_PARTICIPANTS < cars.size();
    }

    private boolean isEmptyOrNoCompetitors(List<Car> cars) {
        return cars.isEmpty() || cars.size() == 1;
    }

    private boolean hasDuplicatedNames(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        Set<String> uniqueCarNames = new HashSet<>(carNames);

        return carNames.size() != uniqueCarNames.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars simulateNextRound(Generator generator) {
        return new Cars(
                cars.stream()
                        .map(car -> car.move(generator.generate()))
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

    public boolean isTie() {
        return cars.stream().allMatch(Car::isNotMoved);
    }

    private Car getFarthestCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElse(null);
    }

}

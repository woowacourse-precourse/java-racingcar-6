package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
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

    public Cars simulateNextRound(RandomNumberGenerator generator) {
        return new Cars(
                cars.stream()
                        .map(car -> car.move(generator.getRandomNumber()))
                        .collect(Collectors.toList())
        );
    }

    public List<String> getWinners() {
        Car highestCar = getHighestPositionCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(highestCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getHighestPositionCar() {
        Car highestCar = cars.get(0);
        for (Car car : cars) {
            if (car.getPosition() > highestCar.getPosition()) {
                highestCar = car;
            }
        }
        return highestCar;
    }
}

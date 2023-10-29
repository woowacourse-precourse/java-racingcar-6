package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(createCar(carNames));
    }

    private static List<Car> createCar(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(Car.createCar(carName));
        }
        return cars;
    }


    public void startRace() {
        for (Car car : cars) {
            car.go();
        }
    }

    public int findFastestCar() {
        List<Integer> carRanks = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return carRanks.get(0);
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}

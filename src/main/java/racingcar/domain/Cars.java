package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsFrom(List<Car> cars) {
        return new Cars(cars);
    }

    public void startRound() {
        for (Car car : cars) {
            car.go();
        }
    }

    private List<Car> findWinners(int fastestCar) {
        return cars.stream().filter(car -> car.isWinner(fastestCar))
                .collect(Collectors.toList());
    }

    public List<Car> findFinalWinners() {
        int fastestCar = findFastestCar();
        return findWinners(fastestCar);
    }

    private int findFastestCar() {
        List<Integer> carRanks = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return carRanks.get(0);
    }


}

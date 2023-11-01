package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.CarNameDuplicationException;

public class RacingCars implements Iterable<Car> {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        checkNameDuplication(cars);

        this.cars = new ArrayList<>(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public void checkNameDuplication(List<Car> cars) {
        List<Car> distinctCars = cars.stream()
                .distinct()
                .toList();
        if (distinctCars.size() != cars.size()) {
            throw new CarNameDuplicationException();
        }
    }

    public String showCarsStates() {
        StringBuilder racingStates = new StringBuilder();

        cars.forEach(car ->
                racingStates.append(String.format("%s : ", car.showName()))
                            .append("-".repeat(car.showForwardCount()))
                            .append("\n")
        );

        return racingStates.toString();

    }

    public RacingWinners calculateRacingWinners() {
        int maxForwardCounts = getMaxForwardCountFromCars();
        List<Car> racingWinners = this.cars.stream()
                                           .filter(car -> car.showForwardCount() == maxForwardCounts)
                                           .toList();
        return new RacingWinners(racingWinners);
    }

    private int getMaxForwardCountFromCars() {
        List<Integer> forwardCounts = cars.stream()
                                          .map(Car::showForwardCount)
                                          .toList();
        return Collections.max(forwardCounts);

    }

}

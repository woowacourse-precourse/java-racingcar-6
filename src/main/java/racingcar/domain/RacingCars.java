package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RacingCars implements Iterable<Car> {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }


    public String showRacingStates() {
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

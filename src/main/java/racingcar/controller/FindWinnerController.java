package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class FindWinnerController {
    private final List<Car> cars;

    public FindWinnerController(final List<Car> cars) {
        
        this.cars = new ArrayList<>(cars);
    }

    public List<String> getWinners() {

        sortedCarByAdvances();
        return findWinner();
    }

    private void sortedCarByAdvances() {

        cars.sort((o1, o2) -> o2.getCarAdvances() - o1.getCarAdvances());
    }

    private List<String> findWinner() {

        int maxAdvance = cars.get(0).getCarAdvances();

        return cars.stream()
                .filter(car -> maxAdvance == car.getCarAdvances())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingStadium {
    private final List<Car> cars;

    public RacingStadium(List<Car> cars) {
        this.cars = cars;
    }

    public void doRace() {
        for (Car car : cars) {
            car.race();
        }
    }

    public List<Car> getWinners() {
        int winnersLocation = getWinnersLocation(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (winnersLocation == car.getLocation()) {
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getWinnersLocation(List<Car> cars) {
        List<Integer> carLocations = new ArrayList<>();
        for (Car car : cars) {
            carLocations.add(car.getLocation());
        }

        return Collections.max(carLocations);
    }
}
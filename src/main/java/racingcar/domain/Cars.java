package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        Position maxPosition = new Position();

        for (Car car : cars) {
            if (car.getPosition().isGreaterThen(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }

        ArrayList<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().equals(maxPosition)) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }
}

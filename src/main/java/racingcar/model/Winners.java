package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public Winners(Cars cars, Attempts attempts) {
        for (Car car : cars.getCarList()) {
            if (car.getDistance().length() == attempts.getNumber()) {
                winners.add(car);
            }
        }
    }

    public List<String> getWinnersNames() {
        List<String> winnersNames = new ArrayList<>();
        for (Car car : winners) {
            winnersNames.add(car.getName());
        }
        return winnersNames;
    }
}

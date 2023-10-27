package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public String announceAllWinners() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance < car.getDistance())
                maxDistance = car.getDistance();
        }

        for (Car car : cars) {
            if (maxDistance == car.getDistance())
                winners.add(car.getName());
        }

        return String.join(", ", winners);
    }
}

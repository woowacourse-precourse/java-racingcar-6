package racingcar.domain;

import java.util.*;

public class Referee {
    List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public String whoIsWinner() {
        int max = maxDistance(this.cars);

        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.distance == max) winner.add(car.name);
        }

        return String.join(", ", winner);
    }

    public int maxDistance(List<Car> cars) {
        List<Integer> carDistance = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carDistance.add(cars.get(i).distance);
        }
        return Collections.max(carDistance);
    }
}

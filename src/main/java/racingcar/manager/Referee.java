package racingcar.manager;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Referee {

    private List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> selectWinner() {

        List<String> winners = new ArrayList<>();
        Car currentWinner = cars.get(0);

        winners.add(currentWinner.getName());

        for (Car car : cars.subList(1, cars.size())) {
            if (currentWinner.compareTo(car) < 0) {
                winners.clear();
            }
            if (currentWinner.compareTo(car) <= 0) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}

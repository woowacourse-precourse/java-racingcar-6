package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> selectWinner() {

        List<String> winners = new ArrayList<>();
        Car currentWinner = cars.get(0);

        winners.add(currentWinner.getName());

        for (Car car : cars.subList(1, cars.size())) {
            int compareState = currentWinner.compareTo(car);
            boolean isChangeWinner = compareState < 0;
            boolean isAddWinner = compareState <= 0;

            if (isChangeWinner) {
                winners.clear();
                currentWinner = car;
            }
            if (isAddWinner) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}

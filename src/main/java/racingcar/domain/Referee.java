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

            if (isChangeWinner(compareState)) {
                winners.clear();
                currentWinner = car;
            }
            if (isAddWinner(compareState)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private boolean isAddWinner(int compareState) {
        return compareState <= 0;
    }

    private boolean isChangeWinner(int compareState) {
        return compareState < 0;
    }
}

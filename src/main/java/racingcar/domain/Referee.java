package racingcar.domain;

import java.util.List;

public class Referee {

    private final List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> selectWinner() {

        Winner winner = new Winner(cars.get(0));
        for (Car car : cars.subList(1, cars.size())) {
            winner.compare(car);
        }

        return winner.getCandidates();
    }
}

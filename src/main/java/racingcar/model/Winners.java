package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {
    private final List<String> winners;

    public Winners(Cars cars) {
        int maxNum = getMaxDistances(cars);
        this.winners = initWinner(cars, maxNum);
    }

    public List<String> getWinners() {
        return winners;
    }

    private List<String> initWinner(Cars cars, int maxNum) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getDistance() == maxNum) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxDistances(Cars cars) {
        List<Integer> distances = new ArrayList<>();
        for (Car car : cars.getCars()) {
            distances.add(car.getDistance());
        }
        return distances.stream().max(Comparator.naturalOrder()).orElse(0);
    }
}

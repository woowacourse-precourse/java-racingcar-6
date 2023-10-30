package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winner {
    private final List<String> winners;
    public Winner(List<Car> cars) {
        int maxNum = getMaxDistances(cars);
        this.winners = initWinner(cars, maxNum);
    }

    public List<String> getWinners() {
        return winners;
    }

    private List<String> initWinner(List<Car> cars, int maxNum) {
        List<String> winners = new ArrayList<>();
        for(Car car: cars) {
            if(car.getDistance() == maxNum)
                winners.add(car.getName());
        }

        return winners;
    }

    private int getMaxDistances(List<Car> cars) {
        List<Integer> distances = new ArrayList<>();
        for(Car car: cars) {
            distances.add(car.getDistance());
        }
        return distances.stream().max(Comparator.naturalOrder()).orElse(0);
    }
}

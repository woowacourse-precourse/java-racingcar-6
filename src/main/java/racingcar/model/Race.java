package racingcar.model;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int totalRounds;
    private int currentRound;

    public Race(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
    }

    public boolean hasMoreRounds() {
        return currentRound < totalRounds;
    }

    public void raceRound(List<Boolean> movableStatuses) {
        int i = 0;
        for (Car car : cars) {
            car.move(movableStatuses.get(i));
            i++;
        }
        currentRound++;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

}

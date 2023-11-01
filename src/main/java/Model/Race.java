package Model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int numOfAttempts;

    public Race(List<Car> cars, int numOfAttempts) {
        this.cars = cars;
        this.numOfAttempts = numOfAttempts;
    }

    public void run() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return findWinners(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<Car> findWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}

package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private List<Car> cars;
    private int tryCount;

    public GameModel(String[] carNames, int tryCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
        tryCount--;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}

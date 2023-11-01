package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private final ArrayList<Car> cars = new ArrayList<>();

    public Game(ArrayList<String> cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    public ArrayList<Car> getRoundResult() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    private ArrayList<Integer> getPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    private int getMaxPosition(ArrayList<Integer> positions) {
        return Collections.max(positions);
    }

    public ArrayList<String> getWinners() {
        int maxPosition = getMaxPosition(getPositions());
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

package racingcar.domain;

import java.util.ArrayList;

public class Game {
    private final ArrayList<Car> cars = new ArrayList<>();

    public Game(ArrayList<String> cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    public ArrayList<Integer> getPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}

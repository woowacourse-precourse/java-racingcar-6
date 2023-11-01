package Model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int maxPosition;

    public Race(List<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        this.maxPosition = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveRole();
        }
    }

    public void maxPosition() {
        for (Car car : cars) {
            maxPosition = comparePosition(maxPosition, car.getPosition());
        }
    }

    public int comparePosition(int position1, int position2) {
        return Math.max(position1, position2);
    }
}

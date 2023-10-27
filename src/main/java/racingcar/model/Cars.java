package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void add(String name) {
        Car car = new Car(name, 0);
        cars.add(car);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

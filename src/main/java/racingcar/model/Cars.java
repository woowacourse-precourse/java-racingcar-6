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

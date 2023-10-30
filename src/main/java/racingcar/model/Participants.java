package racingcar.model;

import java.util.List;
import racingcar.model.car.Car;

public class Participants {
    private final List<Car> list;

    public Participants(List<Car> list) {
        this.list = list;
    }

    public void save(Car car) {
        list.add(car);
    }

    public int size() {
        return list.size();
    }

    public Car get(int index) {
        return list.get(index);
    }
}

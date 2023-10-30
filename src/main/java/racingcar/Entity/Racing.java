package racingcar.Entity;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars = new ArrayList<>();
    private int count;

    public void ready(String[] cars) {
        for (String car : cars) {
            Car racer = new Car(car);
            this.cars.add(racer);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Car> getCars() {
        return cars;
    }
}

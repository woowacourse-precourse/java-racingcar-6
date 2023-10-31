package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int count;

    public Car(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Car> carReset(String[] carNames) {
        carNames = User.splitInput(User.input());
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }
}

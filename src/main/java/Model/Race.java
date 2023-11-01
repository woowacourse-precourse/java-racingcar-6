package Model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveRole();
        }
    }
}

package racingcar.Model;

import java.util.ArrayList;
import java.util.List;


public class Scoreboard {
    public void createAndAddCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        for (Car car : cars) {
            car.getName();
        }
    }

}

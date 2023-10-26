package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;

public class Controller {
    public Controller() {

    }

    public void requestCarGenerate(String[] names) {
        createAndAddCars(names);
    }

    private void createAndAddCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        for (Car car : cars) {
            car.getName();
        }
    }

}

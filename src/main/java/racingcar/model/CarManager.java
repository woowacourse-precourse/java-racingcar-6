package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
        Settings.setCarAmount(cars.size());
    }

    public int getBiggestMove() {
        int biggest = 0;

        for (Car car : cars) {
            if (biggest < car.getMoves()) {
                biggest = car.getMoves();
            }
        }
        return biggest;
    }

    public Car getCarFromIndex(int index) {
        return cars.get(index);
    }

}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(List<Integer> moveNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (moveNumbers.get(i) > 3)
                car.move();
        }
    }

    public int getMaxLocation() {
        List<Integer> carLocations = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            carLocations.add(car.getLocation());
        }
        return Collections.max(carLocations);
    }
}

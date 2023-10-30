package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Random;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void forward() {
        for (Car car : cars) {
            int random = Random.generate();

            int distance = forwardCondition(car, random);

            car.setDistance(distance);
        }
    }

    public int forwardCondition(Car car, int random) {
        int distance = car.getDistance();

        if (Random.isConditionsAdvancementMet(random)) {
            distance += 1;
        }

        return distance;
    }
}

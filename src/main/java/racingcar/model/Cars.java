package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Random;

public class Cars {
    private List<Car> cars;
    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar (Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void forward() {
        for(Car car: cars) {
            int distance = car.getDistance();
            int random = Random.generate();

            if(Random.isConditionsAdvancementMet(random)) {
                distance += 1;
            }

            car.setDistance(distance);
        }
    }
}

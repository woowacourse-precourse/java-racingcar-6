package racingcar;

import java.util.List;
import java.util.Random;

public class CarManager {
    private List<Car> cars;

    public CarManager(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int tryCount) {
        Random random = new Random();
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move(random.nextInt(10));
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}


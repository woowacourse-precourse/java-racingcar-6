package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int BOUNDARY = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car: cars) {
            int randomNumber = RandomNumberGenerator.createRandomNumber();

            if (randomNumber >= BOUNDARY) {
                car.forward();
            }
        }
    }

    public List<Car> getLeadingCar() {
        int maxCount = 0;
        for (Car car: cars) {
            maxCount = Math.max(car.getCount(), maxCount);
        }

        List<Car> leadingCar = new ArrayList<>();
        for (Car car: cars) {
            if (maxCount == car.getCount()) {
                leadingCar.add(car);
            }
        }

        return leadingCar;
    }
}

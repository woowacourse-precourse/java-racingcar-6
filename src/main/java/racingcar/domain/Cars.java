package racingcar.domain;

import java.util.List;

public class Cars {

    private static final int BOUNDARY = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car: cars) {
            int randomNumber = RandomNumberGenerator.createRandomNumber();

            if (randomNumber >= BOUNDARY) {
                car.forward();
            }
        }
    }
}

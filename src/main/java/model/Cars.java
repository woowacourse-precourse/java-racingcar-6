package model;

import java.util.List;

import util.RandomNumber;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (final Car car : cars) {
            int randomNumber = RandomNumber.generateRandomNumber();
            if (randomNumber >= 4) {
                car.moveForward();
            }
        }
    }
}

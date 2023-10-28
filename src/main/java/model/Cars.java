package model;

import java.util.Iterator;
import java.util.List;

import util.RandomNumber;

public class Cars implements Iterable<Car> {
    private static final int STANDARD_NUMBER = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (final Car car : cars) {
            int randomNumber = RandomNumber.generateRandomNumber();
            if (randomNumber >= STANDARD_NUMBER) {
                car.moveForward();
            }
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}

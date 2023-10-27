package racingcar;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public void move() {
        for (Car car : cars) {
            car.moveIfSatisfy();
        }
    }

    public void printCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

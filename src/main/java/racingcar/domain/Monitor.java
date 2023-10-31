package racingcar.domain;

import java.util.List;

public class Monitor {
    List<Car> cars;

    public Monitor(List<Car> cars) {
        this.cars = cars;
    }

    public void printCars() {
        List<Car> cars = this.cars;

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println(car.name + " : " + car.status);
        }
        System.out.println();
    }
}

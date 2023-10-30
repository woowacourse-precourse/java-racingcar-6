package racingcar.domain;

import java.util.List;

public class Monitor {
    List<Car> cars;
    Monitor(List<Car> cars) {
        this.cars = cars;
    }

    public void printCars(Monitor monitor) {
        List<Car> cars = monitor.cars;

    }
}

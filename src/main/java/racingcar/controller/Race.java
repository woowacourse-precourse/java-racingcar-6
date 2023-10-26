package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Race {

    private final List<Car> carList;

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void phase() {
        for (Car car : this.carList) {
            car.move();
        }
    }

    public List<Car> checkWinner() {
        List<Car> list = new ArrayList<>();
        int max = 0;

        for (Car car : this.carList) {
            int distance = car.getDistance();
            if (distance > max) {
                list.clear();
                max = distance;
                list.add(car);
                continue;
            }
            if (distance == max) {
                list.add(car);
            }
        }

        return list;
    }
}

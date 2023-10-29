package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> getList() {
        return cars;
    }

    List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

    List<Integer> getGauges() {
        List<Integer> gauges = new ArrayList<>();
        for (Car car : cars) {
            gauges.add(car.getGauge());
        }
        return gauges;
    }
}

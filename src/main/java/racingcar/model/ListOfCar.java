package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfCar {
    private List<Car> cars;

    public ListOfCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getList() {
        return cars;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

    public List<Integer> getGauges() {
        List<Integer> gauges = new ArrayList<>();
        for (Car car : cars) {
            gauges.add(car.getGauge());
        }
        return gauges;
    }
}

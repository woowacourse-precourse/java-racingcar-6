package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.movable(rolling()));
    }

    private int rolling() {
        return NumberGenerator.generateNumber();
    }

    public List<String> indicate() {
        List<String> indicator = new ArrayList<>();
        cars.forEach(car -> indicator.add(car.indicate()));
        return indicator;
    }

    public int compare(Car car) {
        List<Boolean> collect = cars.stream()
                .map(carObject -> carObject.isLesser(car))
                .filter(result -> !result)
                .toList();
        return collect.size();
    }

}

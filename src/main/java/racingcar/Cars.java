package racingcar;

import java.util.List;

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

    public void indicate() {
        cars.forEach(car -> System.out.println(car.indicate()));
    }

    public List<Boolean> compare(Car car) {
        List<Boolean> collect = cars.stream()
                .map(carObject -> carObject.isLesser(car))
                .filter(result -> !result)
                .toList();
        return collect;
    }

}

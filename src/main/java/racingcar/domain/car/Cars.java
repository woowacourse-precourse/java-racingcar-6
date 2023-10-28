package racingcar.domain.car;

import java.util.List;

public class Cars {

    private final Car car;

    private final List<Car> cars;

    public Cars(Car car, List<Car> cars) {
        this.car = car;
        this.cars = cars;
    }

    public List<Car> changeToCar(List<String> carNames) {
        for (String name : carNames) {
            cars.add(car.of(name));
        }
        return cars;
    }
}

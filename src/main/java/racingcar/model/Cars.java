package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> moveAll() {
        cars.stream().filter(car -> car.createRandomNumber() >= 4)
                .forEach(car -> car.move());
        return cars;
    }


}

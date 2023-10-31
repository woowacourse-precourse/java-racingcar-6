package racingcar.model;

import java.util.List;

public class Cars {


    private final int POSSIBLE_RANDOM_NUMBER = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> moveAll() {
        cars.stream().filter(car -> car.createRandomNumber() >= POSSIBLE_RANDOM_NUMBER)
                .forEach(car -> car.move());
        return cars;
    }


}

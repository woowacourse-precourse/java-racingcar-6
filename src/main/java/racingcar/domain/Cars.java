package racingcar.domain;

import java.util.List;

public class Cars {

    private int size;
    private List<Car> cars;

    public Cars(int size, List<Car> cars) {
        this.size = size;
        this.cars = cars;
    }
}

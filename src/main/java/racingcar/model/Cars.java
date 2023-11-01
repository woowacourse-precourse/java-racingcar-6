package racingcar.model;

import java.util.List;

public class Cars {
    //각각의 자동차 비교, 거리값
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }
}

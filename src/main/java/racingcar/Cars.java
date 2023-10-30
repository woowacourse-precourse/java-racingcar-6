package racingcar;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {

        if (cars.size() == 0) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다");
        }
        this.cars = cars;
    }
}

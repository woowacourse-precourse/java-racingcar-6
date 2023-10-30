package racingcar.domain;

import java.util.List;

public class Cars {
    List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }
}
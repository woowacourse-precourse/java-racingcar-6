package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public List<String> generate(String carName) {
        List<String> cars = new ArrayList<>();
        cars = List.of(carName.split(","));
        return cars;
    }
}

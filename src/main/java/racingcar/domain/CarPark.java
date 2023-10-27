package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vo.Car;

public class CarPark {

    List<Car> park;

    public CarPark(List<Car> park) {
        this.park = park;
    }

    public List<String> makeNameList() {
        return park.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

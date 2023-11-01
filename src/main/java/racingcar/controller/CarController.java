package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarController {

    private final int FORWARD = 4;


    public List<Car> createCars(List<String> names) {
        return names.stream().map(Car::of).collect(Collectors.toList());
    }

    public void race(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= FORWARD) {
            car.forward();
        }
    }
}

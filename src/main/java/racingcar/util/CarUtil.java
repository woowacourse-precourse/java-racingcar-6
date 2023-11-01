package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarUtil {

    public static List<Car> createCar(String cars) {
        List<String> carName = new ArrayList<>(Arrays.asList(cars.split(",")));
        return carName.stream().map(name -> new Car(name)).collect(Collectors.toList());
    }
}

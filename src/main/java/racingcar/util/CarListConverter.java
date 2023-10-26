package racingcar.util;

import racingcar.entity.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarListConverter {

    public static List<Car> convertStringArrayToCarList(String[] names){
        return Arrays.stream(names)
                .distinct()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}

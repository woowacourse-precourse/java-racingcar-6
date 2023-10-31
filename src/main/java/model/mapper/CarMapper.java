package model.mapper;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;

public class CarMapper {

    public static List<String> mapToCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}

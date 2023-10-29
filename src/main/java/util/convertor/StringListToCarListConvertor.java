package util.convertor;

import domain.Car;
import domain.ForwardStrategy;
import factory.CarFactory;
import java.util.List;
import java.util.stream.Collectors;

public class StringListToCarListConvertor {

    private static final int START_LOCATION = 0;

    public static List<Car> convert(List<String> names, ForwardStrategy<?> forwardStrategy) {
        return names.stream()
                .map(name -> CarFactory.createCar(name, START_LOCATION, forwardStrategy))
                .collect(Collectors.toList());
    }
}

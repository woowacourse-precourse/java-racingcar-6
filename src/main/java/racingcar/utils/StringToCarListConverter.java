package racingcar.utils;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToCarListConverter implements Converter<String, List<Car>> {
    private static final String DELIMITER = ",";

    @Override
    public List<Car> convert(String source) {
        return Arrays.stream(source.split(DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

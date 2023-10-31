package racingcar.converter;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class StringToCarListConverter implements Converter<String, List<Car>> {
    private static final String DELIMITER = ",";
    private static final int LIMIT = -1;

    @Override
    public List<Car> convert(String source) {
        return Arrays.stream(source.split(DELIMITER, LIMIT))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}

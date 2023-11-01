package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.constant.Delimiter;

public class CarService {
    public List<Car> createCars(String readLine) {
        String[] carNames = readLine.split(Delimiter.INPUT_NAME_DELIMITER.getValue());
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

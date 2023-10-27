package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.message.ValidateErrorMessage;

public class RacingCar {

    private List<String> cars = new ArrayList<>();

    public void updateCars(String cars) {
        List<String> convertedCars = convert(cars);
        validateCars(convert(cars));
        this.cars = convertedCars;
    }

    private List<String> convert(String cars) {
        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCars(List<String> cars) {
        cars.stream().filter(car -> car.length() > 5)
                .findFirst()
                .ifPresent(s -> new IllegalArgumentException(ValidateErrorMessage.NAME_LENGTH_ERROR));
    }
}

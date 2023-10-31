package racingcar.controller;

import exception.WrongInputException;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private Converter() {
    }

    private static class ConverterHelper {
        private static final Converter INSTANCE = new Converter();
    }

    public static Cars stringToCar(String value) {
        return new Cars(ConverterHelper.INSTANCE.parseToName(value));
    }

    private List<Car> parseToName(String values) {
        String[] names = values.split(",");

        return Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public static int stringToTrial(String value) {
        return ConverterHelper.INSTANCE.parseToTrial(value);
    }

    private int parseToTrial(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new WrongInputException("숫자만 입력해주세요.");
        }
    }
}

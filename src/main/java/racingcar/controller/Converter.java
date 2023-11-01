package racingcar.controller;

import exception.WrongInputException;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;

import java.util.List;

public class Converter {
    private Converter() {
    }

    private static class ConverterHelper {
        private static final Converter INSTANCE = new Converter();
    }

    public static Cars stringToCars(String value) {
        return ConverterHelper.INSTANCE.convertCars(value);
    }

    private Cars convertCars(String value) {
        List<String> splitName = splitNames(value);
        List<Name> names = parseToName(splitName);

        return new Cars(createCar(names));
    }

    private List<String> splitNames(String values) {
        return List.of(values.split(","));
    }

    private List<Name> parseToName(List<String> splitName) {
        return splitName.stream()
                .map(Name::new)
                .toList();
    }

    private List<Car> createCar(List<Name> names) {
        return names.stream()
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

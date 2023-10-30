package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String DELIMITER_OF_INPUT_NAMES = ",";
    List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars of(String names) {
        return new Cars(parseStringToCarList(names));
    }

    private static List<Car> parseStringToCarList(String names) {
        return createCarList(splitNames(names));
    }

    private static List<Car> createCarList(String[] splitNames) {
        return Arrays.stream(splitNames)
                .map(Car::of)
                .toList();
    }

    private static String[] splitNames(String names) {
        return names.split(DELIMITER_OF_INPUT_NAMES);
    }
}
package racingcar.domain;

import static racingcar.global.constants.SymbolType.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> carList;

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
        return names.split(DELIMITER.getSymbol());
    }
}
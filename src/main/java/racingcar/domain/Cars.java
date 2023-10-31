package racingcar.domain;

import static racingcar.global.constants.NumberType.MIN_CAR_SIZE;
import static racingcar.global.constants.SymbolType.DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.global.constants.NumberType;

public class Cars {
    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars of(String names) {
        return new Cars(parseStringToCarList(names));
    }

    private void validateCarList(List<Car> carList) {
        validateListSize(carList);
    }

    private void validateListSize(List<Car> carList) {
        if (hasSingleCar(carList)) {
            throw new IllegalArgumentException(
                    String.format("%d대 이상의 자동차의 이름을 입력해주세요.", MIN_CAR_SIZE.getValue())
            );
        }
    }

    private boolean hasSingleCar(List<Car> carList) {
        return carList.size() < MIN_CAR_SIZE.getValue();
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
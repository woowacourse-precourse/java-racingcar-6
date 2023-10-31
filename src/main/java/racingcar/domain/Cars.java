package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.util.CarsValidator;
import racingcar.util.Constants;

public class Cars {
    private static final String NO_CARS_IN_LIST_ERROR = "자동차 목록이 비어있습니다.";
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(String names) {
        CarsValidator.validateInputWithSeparator(names);

        List<String> carNames = splitToStringList(names);
        List<String> filteredCarNames = filterEmptyNames(carNames);

        CarsValidator.validateCarNames(filteredCarNames);

        List<Car> carList = filteredCarNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    public List<String> findWinners() {
        final Car maxPositionCar = findMaxPosition();
        return findSamePositionCar(maxPositionCar);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    private static List<String> filterEmptyNames(List<String> carNames) {
        return carNames.stream()
                .filter(name -> !name.isEmpty())
                .toList();
    }

    private Car findMaxPosition() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NO_CARS_IN_LIST_ERROR));
    }

    private List<String> findSamePositionCar(Car maxPositionCar) {
        return carList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private static List<String> splitToStringList(String name) {
        return Arrays.stream(name.split(Constants.COMMA))
                .toList();
    }
}

package racingcar.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarListFactory {
    private static final String DELIMITER_CAR_NAMES = ",";

    public static CarList create(final List<Car> cars) {
        final CarList carList = new CarList(cars);
        return carList;
    }

    public static CarList create(final String carNames) {
        final List<String> carNameList = getCarNameListFromCarNames(carNames);
        final List<Car> carList = getCarList(carNameList);
        final CarList carListObject = new CarList(carList);
        return carListObject;
    }

    public static List<String> getCarNameListFromCarNames(final String carNames) {
        final String[] carNamesSplittingByDelimiter = carNames.split(DELIMITER_CAR_NAMES);
        final List<String> carNameList = Arrays.asList(carNamesSplittingByDelimiter)
                .stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
        return carNameList;
    }

    public static List<Car> getCarList(final List<String> carNameList) {
        final List<Car> carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
        return carList;
    }
}

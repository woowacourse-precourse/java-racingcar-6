package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class CarValidator {
    private static final int MINIMUM_CARS_SIZE = 2;
    private static final int MAXIMUM_CARS_SIZE = 5;
    private static final String NAME_REGEX = "^[a-zA-Z가-힣]{1,5}$";
    private static final Pattern pattern = Pattern.compile(NAME_REGEX);

    private CarValidator() {}

    public static void validateCars(List<Car> cars) {
        validateCarSize(cars);
        validateDuplicateName(cars);
    }

    public static void validateName(String name) {
        if (isNotMatchValidNameCondition(name)) {
            throw new IllegalArgumentException("이름은 공백 없는 1~5자의 영어 또는 한글이어야 합니다.");
        }
    }

    private static void validateCarSize(List<Car> cars) {
        if (isOverValidCarSize(cars.size())) {
            throw new IllegalArgumentException("자동차의 갯수는 2~5개 사이여야 합니다.");
        }
    }

    private static void validateDuplicateName(List<Car> cars) {
        if (isContainDuplicateName(cars)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }

    private static boolean isOverValidCarSize(int size) {
        return size < MINIMUM_CARS_SIZE || MAXIMUM_CARS_SIZE < size;
    }

    private static boolean isContainDuplicateName(List<Car> cars) {
        List<Car> target = cars.stream()
                .map(Car::getName)
                .distinct()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        return target.size() != cars.size();
    }

    private static boolean isNotMatchValidNameCondition(String name) {
        return !pattern.matcher(name).matches();
    }
}

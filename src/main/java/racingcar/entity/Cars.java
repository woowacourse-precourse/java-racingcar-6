package racingcar.entity;

import java.util.List;
import java.util.Objects;

class Cars {

    private static final String UNKNOWN_NAMES_MESSAGE = "알 수 없는 목록입니다.";
    private static final String EMPTY_NAMES_MESSAGE = "적어도 하나의 이름이 필요합니다.";
    private static final String DUPLICATION_NAMES_MESSAGE = "중복된 이름은 허용되지 않습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        validate(names);

        return new Cars(mapToCars(names));
    }

    private static void validate(List<String> names) {
        checkNamesNonNull(names);
        checkNamesSize(names);
        checkNamesDuplication(names);
    }

    private static void checkNamesNonNull(List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(UNKNOWN_NAMES_MESSAGE);
        }
    }

    private static void checkNamesSize(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAMES_MESSAGE);
        }
    }

    private static void checkNamesDuplication(List<String> names) {
        long uniqueSize = names.stream()
                .distinct()
                .count();

        if (uniqueSize != names.size()) {
            throw new IllegalArgumentException(DUPLICATION_NAMES_MESSAGE);
        }
    }

    private static List<Car> mapToCars(List<String> names) {
        return names.stream()
                .map(Car::from)
                .toList();
    }

    public int size() {
        return cars.size();
    }
}

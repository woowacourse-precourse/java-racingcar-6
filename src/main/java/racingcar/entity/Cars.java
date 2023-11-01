package racingcar.entity;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final String UNKNOWN_NAMES_MESSAGE = "알 수 없는 목록입니다.";
    private static final String EMPTY_NAMES_MESSAGE = "적어도 하나의 이름이 필요합니다.";
    private static final String DUPLICATION_NAMES_MESSAGE = "중복된 이름은 허용되지 않습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        validate(names);

        return new Cars(mapToCar(names));
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
        if (calculateUniqueSize(names) != names.size()) {
            throw new IllegalArgumentException(DUPLICATION_NAMES_MESSAGE);
        }
    }

    private static long calculateUniqueSize(List<String> names) {
        return names.stream()
                .distinct()
                .count();
    }

    private static List<Car> mapToCar(List<String> names) {
        return names.stream()
                .map(Car::from)
                .toList();
    }

    public void moveAll(MovePolicy policy) {
        cars.forEach(car -> car.move(policy));
    }

    public List<String> findFrontCarsName() {
        List<CarDescription> descriptions = describeAll();

        return findNames(descriptions, findMaxPosition(descriptions));
    }

    public List<CarDescription> describeAll() {
        return cars.stream()
                .map(Car::describeSelf)
                .toList();
    }

    private int findMaxPosition(List<CarDescription> descriptions) {
        return descriptions.stream()
                .map(CarDescription::position)
                .max(Comparator.naturalOrder())
                .orElse(Position.INITIAL_POSITION);
    }

    private List<String> findNames(List<CarDescription> descriptions, int targetPosition) {
        return descriptions.stream()
                .filter(description -> description.position() == targetPosition)
                .map(CarDescription::name)
                .toList();
    }
}

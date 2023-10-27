package racingcar.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RacingCarGame {

    private static final int MAX_NAME_LENGTH = 5;
    private List<Car> cars;

    private RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCarGame from(String[] carNames) {
        validateDuplicatedName(carNames);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            validateNameLength(name);
            validateIsEmpty(name);
            cars.add(Car.from(name));
        }
        return new RacingCarGame(cars);
    }

    private static void validateDuplicatedName(String[] carNames) {
        Set<String> names = new HashSet<>(Arrays.asList(carNames));
        if(carNames.length != names.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private static void validateIsEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름에 공백은 포함될 수 없습니다.");
        }
    }
}

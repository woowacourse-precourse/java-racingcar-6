package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.util.StringUtils;

public class RacingGame {
    private final Cars cars;
    private int gameTry;

    public RacingGame(String carNames, int gameTry) {
        this.cars = initCars(carNames);
        this.gameTry = gameTry;
    }

    private Cars initCars(String carNames) {
        validateCarNames(carNames);
        String[] names = carNames.split(",");
        checkDuplicates(names);
        return createCars(names);
    }

    private static void checkDuplicates(String[] names) {
        if (hasDuplicates(names)) {
            throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
        }
    }

    private static void validateCarNames(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }
    }

    private static boolean hasDuplicates(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        return uniqueNames.size() < names.length;
    }

    private static Cars createCars(String[] names) {
        return new Cars(Arrays
                .stream(names)
                .map(Car::new)
                .toList());
    }
}

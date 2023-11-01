package racingcar.domain;

import static racingcar.util.ExceptionMessage.INVALID_NICKNAME;
import static racingcar.util.ExceptionMessage.INVALID_NUMBER_OF_CARS;
import static racingcar.util.ExceptionMessage.INVALID_UNIQUE_NICKNAME;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.StringUtils;

public class RacingGame {
    private static final String INIT_TRY_NUMBER = "0";
    private static final int SINGLE_CAR = 1;

    private final List<Car> cars;
    private final GameTry gameTry;

    public RacingGame(String carNames) {
        this.cars = initCars(carNames);
        this.gameTry = new GameTry(INIT_TRY_NUMBER);
    }

    public static List<Car> initCars(String carNames) {
        validateCarNames(carNames);
        String[] splitCarNames = StringUtils.splitByDelimiter(carNames);
        checkDuplicates(splitCarNames);
        return createCars(splitCarNames);
    }

    private static void validateCarNames(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException(INVALID_NICKNAME.getMessage());
        }
    }

    private static void checkDuplicates(String[] names) {
        stripCarNames(names);

        if (hasDuplicates(names)) {
            throw new IllegalArgumentException(INVALID_UNIQUE_NICKNAME.getMessage());
        }
        if (hasOneCar(names)) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_CARS.getMessage());
        }
    }

    private static void stripCarNames(String[] names) {
        Arrays.setAll(names, i -> names[i].trim());
    }

    private static boolean hasDuplicates(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        return uniqueNames.size() < names.length;
    }

    private static boolean hasOneCar(String[] names) {
        return names.length == SINGLE_CAR;
    }

    private static List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public boolean isContinue(int targetGameTry) {
        return gameTry.isNotGameEnd(targetGameTry);
    }

    public void race() {
        moveCars();
        increaseGameTry();
    }

    private void moveCars() {
        cars.forEach(car -> car.move(new RandomMovingStrategy()));
    }

    private void increaseGameTry() {
        gameTry.increase();
    }
}

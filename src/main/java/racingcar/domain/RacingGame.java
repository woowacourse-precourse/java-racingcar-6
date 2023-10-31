package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.StringUtils;

public class RacingGame {
    private final List<Car> cars;
    private GameTry gameTry;

    public RacingGame(String carNames) {
        this.cars = initCars(carNames);
        this.gameTry = new GameTry("0");
    }

    public static List<Car> initCars(String carNames) {
        validateCarNames(carNames);
        String[] names = carNames.split(",");
        checkDuplicates(names);
        return createCars(names);
    }

    private static void validateCarNames(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }
    }

    private static void checkDuplicates(String[] names) {
        if (hasDuplicates(names)) {
            throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
        }
    }

    private static boolean hasDuplicates(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        return uniqueNames.size() < names.length;
    }

    private static List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public void race() {
        moveCars();
        increaseGameTry();
    }

    public boolean isContinue(int targetGameTry) {
        return gameTry.isNotGameEnd(targetGameTry);
    }

    private void moveCars() {
        cars.forEach(car -> car.move(new RandomMovingStrategy()));
    }

    private void increaseGameTry() {
        gameTry.increase();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}

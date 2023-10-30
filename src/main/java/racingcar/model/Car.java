package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            distance++;
        }
    }

    public static List<Car> createCars(List<String> carNames) {
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이어야 합니다.");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        for (String name : carNames) {
            validateName(name);
        }
    }
}
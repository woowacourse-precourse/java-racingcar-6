package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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
        if (isInvalidName(name) || containsSpecialCharacters(name)) {
            throw new IllegalArgumentException("자동차 이름은 1~5자이고 공백이 없으며 특수 기호를 포함할 수 없습니다.");
        }
    }

    private static boolean containsSpecialCharacters(String name) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9,가-힣]");
        return pattern.matcher(name).find();
    }

    private static boolean isInvalidName(String name) {
        return name == null || name.trim().isEmpty() || name.trim().length() > MAX_NAME_LENGTH || name.contains(" ");
    }

    private static void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (isInvalidName(name) || uniqueNames.contains(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            uniqueNames.add(name);
        }
    }
}
package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> createCarsFromInput(String names) {
        String[] nameArr = splitNames(names);
        validateUniqueNames(nameArr);
        return createCars(nameArr);
    }

    private static String[] splitNames(String names) {
        return names.trim().split("\\s*,\\s*");
    }

    private static void validateUniqueNames(String[] nameArr) {
        Set<String> nameSet = new HashSet<>(Arrays.asList(nameArr));
        if (nameArr.length != nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static List<Car> createCars(String[] nameArr) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameArr) {
            validateNameLength(name);
            carList.add(new Car(name.trim()));
        }
        return carList;
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}

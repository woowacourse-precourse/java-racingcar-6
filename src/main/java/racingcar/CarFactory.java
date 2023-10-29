package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> createCarsFromInput(String names) {
        String[] nameArr = splitNames(names);
        validateUniqueNames(nameArr);
        return createCars(nameArr);
    }

    public static String[] splitNames(String names) {
        return names.trim().split("\\s*,\\s*");
    }

    public static void validateUniqueNames(String[] nameArr) {
        Set<String> nameSet = new HashSet<>(Arrays.asList(nameArr));
        if (nameArr.length != nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public static List<Car> createCars(String[] nameArr) {
        return Arrays.stream(nameArr)
                .map(name -> {
                    validateNameLength(name);
                    return new Car(name);
                })
                .collect(Collectors.toList());
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
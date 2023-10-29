package racingcar.util;

import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class validation_name {

    public static String validation_name(String names) {
        contain_commas(names);
        List<String> cars = separate_commas(names);
        name_length(cars);
        name_dup(cars);
        return names;
    }

    public static void contain_commas(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException("자동차는 2대 이상이여야 합니다.");
        }
    }

    public static List<String> separate_commas(String names) {
        List<String> cars = Arrays.asList(names.split(","));
        return cars;
    }

    public static void name_length(List<String> cars) {
        for (String i : cars) {
            check_length(i);
        }
    }

    public static void check_length(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void name_dup(List<String> cars) {
        Set<String> carsSet = new HashSet<>(cars);
        if (cars.size() != carsSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되어서는 안됩니다.");
        }
    }

}

package racingcar.util;

import java.util.List;
import java.util.Arrays;

public class validation_name {

    public static String validation_name(String names) {
        contain_commas(names);
        name_length(names);
        return names;
    }

    public static void contain_commas(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException("자동차는 2대 이상이여야 합니다.");
        }
    }

    public static void name_length(String names) {
        List<String> cars = separate_commas(names);
        for (String i : cars) {
            check_length(i);
        }
    }

    public static List<String> separate_commas(String names) {
        List<String> cars = Arrays.asList(names.split(","));
        return cars;
    }

    public static void check_length(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

}

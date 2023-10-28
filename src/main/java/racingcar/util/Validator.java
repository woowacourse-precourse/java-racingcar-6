package racingcar.util;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.domain.Constants;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static void InputRaceCount(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }

    public static void InputCarName(List<String> cars) {
        if (!InputNameLength(cars)) {
            throw new IllegalArgumentException("이름이 5자를 초과를 초과하지마세요");
        }
        if (!InputNameDuplicatin(cars)) {
            throw new IllegalArgumentException("중복된 이름을 입력하지마세요");
        }
    }

    private static boolean InputNameLength(List<String> cars) {
        return cars.stream()
                .noneMatch(name -> name.length() > Constants.NAME_SIZE);
    }

    private static boolean InputNameDuplicatin(List<String> cars) {
        return cars.stream().distinct().count() == cars.size();
    }

}

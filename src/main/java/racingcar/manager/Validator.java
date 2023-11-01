package racingcar.manager;

import java.util.HashSet;
import java.util.Set;
import static racingcar.Vars.LENGTH_CAR_NAME;

public class Validator {
    public Validator(String name) {
    validateCarNameLength(name);
    }

    public static void validateCarNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > LENGTH_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1~" + LENGTH_CAR_NAME + "자만 가능합니다.");
        }
    }

    public static void validateNoDuplicateNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            validateUniqueName(uniqueNames, name);
        }
    }

    private static void validateUniqueName(Set<String> uniqueNames, String name) {
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다: " + name);
        }
    }

    public static int validateRaceRoundInput(String input) {
        int round = convertToInteger(input);
        validateIsPositiveInteger(round);
        return round;
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("레이스 라운드는 숫자만 입력 가능합니다.");
        }
    }

    public static void validateIsPositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("레이스 라운드는 양의 정수만 가능합니다.");
        }
    }
}

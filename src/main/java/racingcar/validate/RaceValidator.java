package racingcar.validate;

import java.util.HashSet;

public class RaceValidator {
    public static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
        }
    }

    public static int validateTrials(String trial) {
        try {
            return Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수 형식이 아닙니다.");
        }
    }
}

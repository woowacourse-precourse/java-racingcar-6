package racingcar.validate;

import java.util.LinkedHashMap;

public class RacingListValidator {
    public static void sizeValidate(String input) {
        int size = input.length();
        if (size > 5) {
            throw new IllegalArgumentException("이름의 길이가 5 이상입니다.");
        }
    }

    public static void duplicateValidate(LinkedHashMap<String, Integer> carList, String input) {
        if (carList.containsKey(input)) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }
}

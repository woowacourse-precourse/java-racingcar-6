package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void inputCarNames(String[] carNameArr) {
        if (hasDuplicates(carNameArr)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        for (String carName : carNameArr) {
            if (hasWhitespace(carName)) {
                throw new IllegalArgumentException("이름에 공백이 존재합니다.");
            }
            if (isValidLength(carName)) {
                continue;
            }
            throw new IllegalArgumentException("이름은 1~5자만 가능합니다.");
        }
    }

    private static boolean hasWhitespace(String carName) {
        return carName.contains(" ");
    }

    private static boolean isValidLength(String carName) {
        return 1 <= carName.length() && carName.length() <= 5;
    }

    private static boolean hasDuplicates(String[] carNameArr) {
        List<String> carNameList = arrayToList(carNameArr);
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    private static List<String> arrayToList(String[] carNameArr) {
        return Arrays.stream(carNameArr).toList();
    }

    public static void isInteger(String attemptCount) {
        try {
            Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}

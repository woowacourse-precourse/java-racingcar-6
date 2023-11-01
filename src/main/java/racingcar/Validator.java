package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void carNamesValidation(String carNames) {
        List<String> carNameList = getCarNamesByCondition(carNames);

        checkHasOverFiveCharOrSpace(carNames, carNameList);
        checkHasEmptyName(carNames, carNameList);
    }

    private static List<String> getCarNamesByCondition(String carNames) {
        return Arrays.stream(carNames.split(","))
                .filter(name -> name.length() <= CAR_NAME_LENGTH_LIMIT)
                .filter(name -> !name.contains(" "))
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

    private static void checkHasOverFiveCharOrSpace(String carNames, List<String> carNameList) {
        if (carNameList.size() != carNames.split(",").length) {
            throw new IllegalArgumentException("자동차 이름은 공백이 아닌 5자 이하만 가능합니다.");
        }
    }

    private static void checkHasEmptyName(String carNames, List<String> carNameList) {
        if (carNameList.size() != countChar(carNames, ',') + 1) {
            throw new IllegalArgumentException("자동차 이름을 빈 문자열로 정할 수 없습니다.");
        }
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static int checkIsPositiveInteger(String inputRepetitions) {
        try {
            int trialTimes = Integer.parseInt(inputRepetitions);
            if (trialTimes <= 0) {
                throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
            }
            return trialTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
        }
    }
}

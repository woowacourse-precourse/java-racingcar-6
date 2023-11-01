package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void carNamesValidation(String carNames) {
        List<String> carNameList = getCarNamesUnderFiveChar(carNames);

        checkHasOverFiveChar(carNames, carNameList);
        checkHasEmptyName(carNames, carNameList);
    }

    private static List<String> getCarNamesUnderFiveChar(String carNames) {
        return Arrays.stream(carNames.split(","))
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());
    }

    private static void checkHasOverFiveChar(String carNames, List<String> carNameList) {
        if (carNameList.size() != carNames.split(",").length) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
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

    public static int checkIsPositiveInteger(String inputTrialTimes) {
        try {
            int trialTimes = Integer.parseInt(inputTrialTimes);
            if (trialTimes <= 0) {
                throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
            }
            return trialTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
        }
    }
}

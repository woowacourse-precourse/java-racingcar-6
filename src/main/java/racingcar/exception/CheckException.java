package racingcar.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckException {

    public static void checkSplitCarNameException(String[] carName) {

        for (String oneCar : carName) {
            if (oneCar.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        Set<String> set = new HashSet<String>(Arrays.asList(carName));
        if (set.size() != carName.length) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public static int checkAssignChallengeNumber(String number) {
        int intNumber = 0;

        try {
            intNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new java.lang.IllegalArgumentException("정수를 입력해주세요.");
        }

        if (intNumber < 0) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }

        return intNumber;
    }
}

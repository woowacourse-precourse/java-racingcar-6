package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    // 얘네도 객체를 생성해야하나.. static으로 해야하나
    public static void validateCarName(final List<String> carNameList) {
        isNull(carNameList);
        isOverFive(carNameList);
        isOverlapping(carNameList);
    }

    public static void validateAttemptNumber(final String attemptNumber) {
        isNullString(attemptNumber);
        isNotInteger(attemptNumber);
        isBelowZero(attemptNumber);
    }

    // 나중에 하낳나 테스트하려면 public 해야할텐데
    public static void isNull(final List<String> carNameList) {
        if (carNameList.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 게임을 종료합니다.");
        }
    }

    public static void isOverFive(final List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("입력값이 5자를 초과하였습니다. 게임을 종료합니다.");
            }
        }
    }

    public static void isOverlapping(final List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복되는 입력값이 있습니다. 게임을 종료합니다.");
        }
    }

    public static void isNullString(final String attemptNumber) {
        if (attemptNumber.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 게임을 종료합니다.");
        }
    }

    public static void isNotInteger(final String attemptNumber) {
        for (int i = 0; i < attemptNumber.length(); i++) {
            if (!Character.isDigit(attemptNumber.charAt(i))) {
                throw new IllegalArgumentException("입력값은 정수여야 합니다. 게임을 종료합니다.");
            }
        }
    }

    public static void isBelowZero(final String attemptNumber) {
        if (Integer.parseInt(attemptNumber) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다. 게임을 종료합니다.");
        }
    }
}
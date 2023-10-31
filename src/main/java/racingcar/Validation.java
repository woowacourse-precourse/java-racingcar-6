package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    // 얘네도 객체를 생성해야하나.. static으로 해야하나
    public static void validateCarName(final List<String> carNameList) {
        checkIfNullOrBlankList(carNameList);
        checkIfAnyBelowOneLength(carNameList);
        checkIfAnyOverFiveLength(carNameList);
        checkIfAnyOverlapping(carNameList);
    }

    public static void validateAttemptNumber(final String attemptNumber) {
        checkIfNullOrBlankString(attemptNumber);
        checkIfNotInteger(attemptNumber);
        checkIfNotPositiveNumber(attemptNumber);
    }

    public static void checkIfNullOrBlankList(final List<String> carNameList) {
        if (carNameList.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없거나 빈 공백만으로 이뤄져있습니다. 게임을 종료합니다.");
        }
    }

    public static void checkIfAnyBelowOneLength(final List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상이여야 합니다. 게임을 종료합니다.");
            }
        }
    }

    public static void checkIfAnyOverFiveLength(final List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과하였습니다. 게임을 종료합니다.");
            }
        }
    }

    public static void checkIfAnyOverlapping(final List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다. 게임을 종료합니다.");
        }
    }

    public static void checkIfNullOrBlankString(final String attemptNumber) {
        if (attemptNumber.isBlank()) {
            throw new IllegalArgumentException("입력값이 없거나 빈 공백으로 이뤄져있습니다. 게임을 종료합니다.");
        }
    }

    public static void checkIfNotInteger(final String attemptNumber) {
        for (int i = 0; i < attemptNumber.length(); i++) {
            if (!Character.isDigit(attemptNumber.charAt(i))) {
                throw new IllegalArgumentException("시도 횟수는 정수여야 합니다. 게임을 종료합니다.");
            }
        }
    }

    public static void checkIfNotPositiveNumber(final String attemptNumber) {
        if (Integer.parseInt(attemptNumber) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다. 게임을 종료합니다.");
        }
    }
}
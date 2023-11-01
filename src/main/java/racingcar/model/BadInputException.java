package racingcar.model;

import java.util.HashSet;
import java.util.Set;

public class BadInputException {
    public static void checkNumber(String attemptCount) {
        try {
            int number = Integer.parseInt(attemptCount);
            if (!isPositiveNum(number)) {
                throw new IllegalArgumentException("양의 정수 여야합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자이여야 합니다.");
        }
    }

    public static boolean isPositiveNum(int attemptCount) {
        if (attemptCount > 0) {
            return true;
        }
        return false;
    }

    public static void isSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함되어 있습니다.");
        }
    }

    public static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
    }

    public static void checkMinimumParticipants(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("참여자는 2명 이상이여야 합니다.");
        }
    }

    public static void isNameDuplicate(String[] names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 이름이 존재합니다: " + name);
            }
        }
    }
}

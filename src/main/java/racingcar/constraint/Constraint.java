package racingcar.constraint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Constraint {
    private static final int MAX_NUM_LENGTH = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MIN_NUM = 1;

    public static void constraintRange(int number) {
        if (number < MIN_NUM) {
            throw new IllegalArgumentException("0보다 큰 수를 입력하세요.");
        }
    }

    public static void constraintLength(List<String> nameList) {
        if (nameList.size() < MIN_NUMBER_OF_NAMES) {
            throw new IllegalArgumentException("자동차 이름을 2개 이상 입력하세요.");
        }
    }

    public static void constraintNameLength(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > MAX_NUM_LENGTH) {
                throw new IllegalArgumentException(String.format("최대 이름 길이인 %d를 넘는 이름입니다.", MAX_NUM_LENGTH));
            }
        }
    }

    public static void constraintUnique(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException("이름 중에 중복이 있습니다.");
        }
    }

    public static void constraintInt(String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("정수 값이 아닙니다.");
        }
    }

    public static void constraintEmptyInput(String strInput) {
        if (strInput.isEmpty()) {
            throw new IllegalArgumentException("빈칸입니다.");
        }
    }
}

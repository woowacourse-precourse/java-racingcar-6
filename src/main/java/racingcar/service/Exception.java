package racingcar.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    private static List<String> carNames;
    public static void checkCarName(String input) throws IllegalArgumentException {
        checkEmpty(input);

        carNames = Arrays.asList(input.split(","));
        for (String e : carNames) {
            checkNoName(e);
            checkblank(e);
            checkLength(e);
        }

        checkSameName();
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름을 입력해주세요.");
        }
    }

    private static void checkNoName(String input) {
        if (input.isEmpty() || input.equals(" ")) {
            throw new IllegalArgumentException("잘못된 값 입력 : 입력되지 않은 자동차 이름이 있습니다.");
        }
    }

    private static void checkblank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    private static void checkLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름은 5자 이내로 입력해주세요");
        }
    }

    private static void checkSameName() {
        Set<String> set = new HashSet<>(carNames);
        if (carNames.size() != set.size()) {
            throw new IllegalArgumentException("잘못된 값 입력 : 중복된 자동차 이름이 있습니다.");
        }
    }
}
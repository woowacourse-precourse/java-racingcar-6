package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public static List<String> validateCarNames(String input) {
        validateBlank(input);
        validateStartsOrEndsWith(input);
        List<String> names = Arrays.asList(input.split(","));
        validateSize(names);
        validateLength(names);
        validateDuplicate(names);
        //TODO 공백을 포함하여 문자열 길이를 계산하고 문자열을 비교해도 될까 (ex. "test" 와 " test")
        return names;
    }

    private static void validateSize(List<String> names) {
        if (names.size() == 1) {
            throw new IllegalArgumentException("[ERROR] 게임 진행을 위해 자동차 이름을 최소 2개 이상 입력해주세요.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다. 자동차 이름을 입력해주세요.");
        }
    }

    private static void validateStartsOrEndsWith(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 쉼표로 구분하여 입력해주세요.");
        }
    }

    private static void validateLength(List<String> names) {
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 각 자동차의 이름은 공백이 아니어야 하고, 최소 한글자 이상 이어야 합니다.");
            }
            if (name.length() >= MAXIMUM_NAME_LENGTH + 1) {
                throw new IllegalArgumentException("[ERROR] 각 자동차의 이름을 5글자 이하로 입력해주세요.");
            }
        }
    }

    private static void validateDuplicate(List<String> names) {
        HashSet<String> namesToSet = new HashSet<>(names);
        if (names.size() != namesToSet.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 자동차 이름을 입력해주세요.");
        }
    }


}

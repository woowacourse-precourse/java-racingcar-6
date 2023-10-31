package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Exceptions {
    public static void validateNameInput(String input) {
        inputNullException(input);
        singleNameException(input);
    }

    public static void validateNamesList(List<String> names) {
        for (String name : names) {
            nameTooLongException(name);
        }
        nameDuplicateException(names);
    }

    public static void validateTrialInput(String trial) {
        inputNullException(trial);
        isNumberCheck(trial);
    }

    private static void inputNullException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("인풋값이 없습니다.");
        }
    }

    private static void singleNameException(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("하나의 이름만 입력되었습니다. 쉼표(,)로 구분해주세요.");
        }
    }

    private static void nameTooLongException(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5글자를 초과했습니다: " + name);
        }

    }

    private static void nameDuplicateException(List<String> names) {
        Set<String> namesSet = new HashSet<String>(names);
        if (names.size() > namesSet.size()) {
            throw new IllegalArgumentException("중복 이름이 존재합니다.");
        }
    }

    private static void isNumberCheck(String trial) {
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}

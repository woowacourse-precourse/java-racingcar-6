package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputChecker {
    static final String DELIMITER = ",";
    static final int NAME_LENGTH_MAX = 5;
    public static List<String> checkCharacter(String input) {
        if (!input.matches("^[\\w" + DELIMITER + "]+$")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return Arrays.asList(input.split(DELIMITER));
    }
    public static void checkOverlap(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
    public static void checkNameLength(List<String> carNames) {
        for (String name : carNames) {
            int nameLength = name.length();
            if (nameLength < 1 || nameLength > NAME_LENGTH_MAX) {
                throw new IllegalArgumentException("이름의 길이가 맞지 않습니다.");
            }
        }
    }
}

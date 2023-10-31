package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class NameValidator {
    public NameValidator() {
    }

    public static List<String> splitComma(String names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names.split(",")) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("빈 값을 입력하여 게임을 종료합니다.");
            }
            nameList.add(name);
        }
        if (nameList.size() != names.chars().filter(comma -> comma == ',').count() + 1) {
            throw new IllegalArgumentException("빈 값을 입력하여 게임을 종료합니다.");
        }
        return nameList;
    }

    public static boolean correctNumberOfChar(List<String> carNameList) {
        for (String name : carNameList) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasOnlyAlphabets(List<String> carNameList) {
        for (String name : carNameList) {
            if (!name.matches("^[a-zA-Z]*$")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotRedundant(List<String> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            return false;
        }
        return true;
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class NameValidator {
    public NameValidator() {
    }

    public static List<String> validate(String names) {
        List<String> nameList = splitComma(names);
        correctNumberOfChar(nameList);
        hasOnlyAlphabets(nameList);
        hasUniqueName(nameList);
        isUnderTen(nameList);
        return nameList;
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

    public static void correctNumberOfChar(List<String> carNameList) {
        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("글자 수를 초과 입력하여 게임을 종료합니다. (자동차 이름 글자 수는 5자 이하 까지 가능합니다.)");
            }
        }
    }

    public static void hasOnlyAlphabets(List<String> carNameList) {
        for (String name : carNameList) {
            if (!name.matches("^[a-zA-Z]*$")) {
                throw new IllegalArgumentException("영문자 외의 값을 입력하여 게임을 종료합니다.");
            }
        }
    }

    public static void hasUniqueName(List<String> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 값을 입력하여 게임을 종료합니다.");
        }
    }

    public static void isUnderTen(List<String> carNameList) {
        if (carNameList.size() > 10) {
            throw new IllegalArgumentException("자동차의 수가 10대를 초과하여 게임을 종료합니다.");
        }
    }
}

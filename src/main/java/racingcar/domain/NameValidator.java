package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class NameValidator {
    public static List<String> splitComma(String names) {
        List<String> nameList = new ArrayList<String>();
        for (String name : names.split(",")) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
            }
            if (nameList.contains(name)) {
                throw new IllegalArgumentException("중복된 값을 입력하여 게임을 종료합니다.");
            }
            nameList.add(name);
        }
        return nameList;
    }

    public boolean correctNumberOfString(String name) {
        return false;
    }

    public boolean hasOnlyAlphabets(String name) {
        return false;
    }

    public boolean isNotRedundant() {
        return false;
    }
}

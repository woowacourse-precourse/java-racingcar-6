package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    public void checkName(List<String> nameList) {
        checkNameOver5(nameList);
        checkDuplicatedName(nameList);
    }


    public void checkNameOver5(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하로 이름을 작성해 주세요.");
            }
        }
    }

    public void checkDuplicatedName(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameList.size() > nameSet.size()) {
            throw new IllegalArgumentException("겹치지 않은 이름을 입력해 주세요.");
        }
    }

    public void checkNumber(String names) {
        if (!names.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}

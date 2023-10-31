package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Name {
    private final String name;

    public Name(final String name) {
        validateCarNameValid(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void validateCarNameValid(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 작성해주세요.");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력해주세요.");
        }
    }
}

package racingcar.domain;

import racingcar.util.StringUtils;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = validation(name);
    }

    private String validation(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자까지 가능합니다.");
        }
        return name;
    }
}

package racingcar.domain.car;

import racingcar.utils.Validator;

public class Name {
    private static final String NAME_BY_OVERSIZE = "[ERROR] 이름은 5자 이하로 입력해주세요.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        Validator.validateIsBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_BY_OVERSIZE);
        }
    }
}

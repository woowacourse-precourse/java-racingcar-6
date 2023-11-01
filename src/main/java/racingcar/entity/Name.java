package racingcar.entity;

import java.util.Objects;

class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String UNKNOWN_NAME_MESSAGE = "알 수 없는 이름입니다.";
    private static final String EXCEED_NAME_LENGTH_MESSAGE = "이름은 최대 " + MAX_NAME_LENGTH + "글자까지 입력할 수 있습니다.";

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        validate(name);

        return new Name(name);
    }

    private static void validate(String name) {
        checkNameNonNull(name);
        checkNameLength(name);
    }

    private static void checkNameNonNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(UNKNOWN_NAME_MESSAGE);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}

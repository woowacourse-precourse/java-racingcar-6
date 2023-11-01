package racingcar.domain;

public class Name {

    private static final String NAME_RANGE_EXCEPTION_MESSAGE = " 이름은 5자 이하만 가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private final String value;

    public Name(String name) {
        validateLengthOf(name);
        this.value = name;
    }

    private void validateLengthOf(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(NAME_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}

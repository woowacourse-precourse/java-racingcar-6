package racingcar.model.car;

public record Name(String name) {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_MESSAGE_FORMAT = "[%s] : 이름의 길이는 %d이상 %d이하로 입력해주세요.";

    public Name {
        validateNameLength(name);
    }

    public static Name from(String name) {
        return new Name(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(
                    NAME_LENGTH_MESSAGE_FORMAT.formatted(name, MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

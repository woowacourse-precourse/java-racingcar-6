package racingcar.model;

public class Name {

    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(final String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 1자 이상 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}

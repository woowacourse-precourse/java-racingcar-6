package racingcar;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validateName(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 " + MAX_NAME_LENGTH + "를 넘을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

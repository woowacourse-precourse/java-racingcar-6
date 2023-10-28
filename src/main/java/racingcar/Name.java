package racingcar;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(Name name) {
        this.name = name.name;
    }

    public Name(String name) {
        validateName(name);
        this.name = name;
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

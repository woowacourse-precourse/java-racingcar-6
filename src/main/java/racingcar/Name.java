package racingcar;

public class Name {

    private String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상 입력");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자 이하로 입력");
        }
    }
}

package racingcar.domain;

public class Name {

    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String name) {
        checkBlank(name);
        checkLength(name);
        checkNumeric(name);
    }

    public String getValue() {
        return value;
    }

    private void checkBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력 불가능 합니다.");
        }
    }

    private void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름만 가능합니다.");
        }
    }

    private void checkNumeric(String name) {
        if (name.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자는 입력 불가능 합니다.");
        }
    }
}

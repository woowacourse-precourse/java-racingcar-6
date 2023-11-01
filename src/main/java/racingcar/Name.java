package racingcar;

public class Name {
    private String value;

    Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}

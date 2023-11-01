package racingcar;

public class CarName {
    private final String name;

    public CarName(final String name) {
        validateLength(name);
        validateEmpty(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateEmpty(String name) {
        if (isEmptyValue(name)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (isOverLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 까지만 입력할 수 있습니다.");
        }
    }

    private boolean isEmptyValue(String name) {
        return name.trim().isBlank();
    }

    private boolean isOverLength(String name) {
        return 5 < name.length();
    }
}

package racingcar;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateLength(String name) {
        if (isOverLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 까지만 입력할 수 있습니다.");
        }
    }

    private boolean isOverLength(String name) {
        return 5 < name.length();
    }
}

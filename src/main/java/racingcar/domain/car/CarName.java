package racingcar.domain.car;

public class CarName {
    private static final int MAXIMUM_LENGTH = 5;
    String name;

    protected CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 됩니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }
}

package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 잘못되었습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과입니다.");
        }
    }

    public String getName() {
        return name;
    }
}

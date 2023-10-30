package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {

        validateBlack(name);
        validateLength(name);

        this.name = name;
    }

    private void validateLength(String name) {
        if (!(MIN_LENGTH <= name.length() && name.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException("자동차 이름 길이가 올바르지 않습니다");
        }
    }

    private void validateBlack(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}

package racingcar.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarName otherCarName = (CarName) obj;
        return Objects.equals(name, otherCarName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}

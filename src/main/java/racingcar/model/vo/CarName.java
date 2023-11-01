package racingcar.model.vo;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String carName) {
        validate(carName);
        this.name = carName;
    }

    private void validate(String carName) {
        isLengthLessThan5(carName);
        isBlank(carName);
    }

    private void isLengthLessThan5(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    private void isBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("이름에 빈 값이 들어올 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

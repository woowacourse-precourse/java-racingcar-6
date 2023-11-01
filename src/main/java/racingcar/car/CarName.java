package racingcar.car;

import java.util.Objects;

public class CarName {
    public static final int NAME_LENGTH_UPPER_BOUND = 5;
    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        validateEmpty(carName);
        validateLength(carName);
    }

    private void validateEmpty(String carName) {
        if (carName.isBlank() || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 비어 있을 수 없습니다.");
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException("자동차 이름의 길이가 적절하지 않습니다. " + NAME_LENGTH_UPPER_BOUND + "자 이하로 입력해주세요.");
        }
    }

    public String getName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return "CarName{" +
                "carName='" + carName + '\'' +
                '}';
    }
}

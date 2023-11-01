package racingcar;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private String name;

    public CarName(String carName) {
        validate(carName);
        name = carName;
    }

    private void validate(String carName) {
        checkBlank(carName);
        checkLength(carName);
    }

    private void checkBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private void checkLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 공백 포함 " + MAX_LENGTH + "자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName carName1)) {
            return false;
        }
        return Objects.equals(name, carName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
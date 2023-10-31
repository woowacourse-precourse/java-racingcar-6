package racingcar.domain.car;

import java.util.List;
import java.util.Objects;
import racingcar.util.Err;
import racingcar.util.StringUtils;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    private CarName(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    private void validateCarNameLength(String name) {
        validateCarNameMinLength(name);
        validateCarNameMaxLength(name);
        validateUniqueCarCount(name);
    }

    private void validateCarNameMinLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Err.INVALID_CAR_NAME_MIN_LENGTH.getMessage());
        }
    }

    private void validateUniqueCarCount(String name) {
        List<String> carNames = StringUtils.splitStringToList(name);
        int uniqueCarNameCount = (int) carNames.stream().distinct().count();

        if (uniqueCarNameCount != carNames.size()) {
            throw new IllegalArgumentException(Err.INSUFFICIENT_CAR_COUNT.getMessage());
        }
    }

    private void validateCarNameMaxLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Err.INVALID_CAR_NAME_MAX_LENGTH.getMessage());
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
        if (!(o instanceof CarName carName)) {
            return false;
        }
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

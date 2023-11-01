package racingcar.domain;

import java.util.List;

public class Winner {
    private final List<String> names;

    private Winner(final List<String> names) {
        validate(names);
        this.names = names;
    }

    public static Winner createFrom(final Cars cars) {
        int maxPosition = cars.getMaxPosition();
        List<String> names = cars.getSamePositionCarNames(maxPosition);
        return new Winner(names);
    }

    private void validate(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("우승자는 한 명 이상 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return String.join(", ", names);
    }
}

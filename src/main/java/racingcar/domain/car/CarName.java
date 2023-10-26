package racingcar.domain.car;

public class CarName {

    private static final int NAME_MIN_SIZE = 1;
    private static final int NAME_MAX_SIZE = 5;
    private static final String ERROR_MESSAGE_INVALID_SIZE = "자동차의 이름은 1자리 이상 5자리 이하입니다.";

    private final String name;

    public CarName(String name) {
        validateSize(name);
        this.name = name;
    }

    private void validateSize(String name) {
        if (!isRightSize(name)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_SIZE);
        }
    }

    private boolean isRightSize(String name) {
        return name.length() >= NAME_MIN_SIZE && name.length() <= NAME_MAX_SIZE;
    }

    public String name() {
        return name;
    }
}

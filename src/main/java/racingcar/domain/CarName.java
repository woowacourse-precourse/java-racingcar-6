package racingcar.domain;

public record CarName(String name) {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "자동차 이름 길이가 올바르지 않습니다";
    private static final String NOT_BLANK_CAR_NAME = "자동차 이름은 비어있을 수 없습니다.";

    public CarName {

        validateBlack(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (!(MIN_LENGTH <= name.length() && name.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    private void validateBlack(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException(NOT_BLANK_CAR_NAME);
        }
    }
}

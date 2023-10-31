package racingcar.util;

public class Exception {
    private static final int CAR_NAME_LIMIT_MIN = 1;
    private static final int CAR_NAME_LIMIT_MAX = 5;
    private static final String SPACE = " ";

    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkLengthAndThrowException(input);
        checkSpaceAndThrowException(input);
    }

    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("자동차 이름안에 공백을 제거하세요.");
    }



    private void checkLengthAndThrowException(String carName) {
        if (CAR_NAME_LIMIT_MAX < carName.length()) {
            throwMaxLengthException();
        }
        if (carName.length() < CAR_NAME_LIMIT_MIN) {
            throwMinLengthException();
        }
    }

    private void throwMinLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LIMIT_MIN + "글자 이상이어야 합니다.");
    }

    private void throwMaxLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LIMIT_MAX + "글자 이하여야 합니다.");
    }
}

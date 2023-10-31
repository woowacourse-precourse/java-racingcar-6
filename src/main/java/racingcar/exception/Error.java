package racingcar.exception;

public class Error {

    public static void validateInputs(int tryCount, String[] carNames) {
        if (tryCount <= 0 || carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }

        for (String carName : carNames) {
            if (carName == null || carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다: " + carName);
            }
        }
    }
}

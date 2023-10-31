package racingcar.exception.trycnt;

public class TryCntIsNumberException extends IllegalArgumentException {
    private static final String TRY_CNT_IS_NUMBER = "시도 횟수는 숫자여야 합니다.";

    public TryCntIsNumberException() {
        super(TRY_CNT_IS_NUMBER);
    }
}

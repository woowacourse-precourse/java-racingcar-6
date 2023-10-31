package racingcar.exception.trycnt;

public class TryCntIsPositiveException extends IllegalArgumentException {
    private static final String TRY_CNT_IS_POSITIVE = "시도 횟수는 양수여야 합니다.";

    public TryCntIsPositiveException() {
        super(TRY_CNT_IS_POSITIVE);
    }
}

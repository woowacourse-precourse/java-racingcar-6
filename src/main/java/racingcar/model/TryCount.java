package racingcar.model;

public class TryCount {
    public static final String INPUT_TRYCOUNT = "숫자만 입력 가능합니다.";

    private static final String INPUT_NUMBER_TYPE = "^\\d+$";

    private final String tryCount;

    public TryCount(String tryCount) {
        this.tryCount = validateTryCount(tryCount);
    }

    private String validateTryCount(String tryCount) {
        if (!tryCount.matches(INPUT_NUMBER_TYPE)) {
            throw new IllegalArgumentException(INPUT_TRYCOUNT);
        }
        return tryCount;
    }

    public String getTryCount() {
        return tryCount;
    }
}

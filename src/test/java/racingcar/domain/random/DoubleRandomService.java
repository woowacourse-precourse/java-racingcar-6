package racingcar.domain.random;

public class DoubleRandomService implements RandomService {
    public static final String DOUBLE_VALUE_OUT_OF_THE_RANGE_EXCEPTION = "대역의 값이 범위에 존재하지 않습니다!";
    private final int number;

    public DoubleRandomService(int number) {
        this.number = number;
    }

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        if (startInclusive <= number && number <= endInclusive) {
            return number;
        }
        throw new IllegalArgumentException(DOUBLE_VALUE_OUT_OF_THE_RANGE_EXCEPTION);
    }
}

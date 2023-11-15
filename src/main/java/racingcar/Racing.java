package racingcar;

public class Racing {

    private final int value;

    private Racing(final String value) {
        int convertedValue = parseint(value);
        validate(convertedValue);
        this.value = convertedValue;
    }

    public static Racing of(String value) {
        return new Racing(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(final int convertedValue) {
        if (convertedValue < 0) {
            throw new IllegalArgumentException("시도횟수는 양수여야합니다");
        }
    }

    private int parseint(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }
    }
}

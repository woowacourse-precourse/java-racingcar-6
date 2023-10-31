package racingcar;

public class Lap {
    private static final String REGEXP_SIZE_FORMAT = "[1-9]+";
    private static final int MINIMUM_SIZE = 1;

    private final int size;

    public Lap(String size) {
        validateFormatCheck(size);
        this.size = Integer.parseInt(size);
    }

    public Lap(int size) {
        validateSizeCheck(size);
        this.size = size;
    }

    private void validateFormatCheck(String size) {
        if (!size.matches(REGEXP_SIZE_FORMAT)) {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.NOT_NUMBER_FORMAT);
        }
    }

    private void validateSizeCheck(int size) {
        if (size < MINIMUM_SIZE) {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.MINUS_NUMBER);
        }
    }

    public boolean isFinish(Lap lap) {
        return this.size < lap.size;
    }

}

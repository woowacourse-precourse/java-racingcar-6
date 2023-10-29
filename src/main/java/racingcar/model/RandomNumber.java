package racingcar.model;

public class RandomNumber {

    private static final int MOVE_THRESHOLD = 4;

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final int number;

    public RandomNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(final int number) {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException("[Error] 랜덤 생성 숫자는 0~9사이의 숫자여야 합니다.");
        }
    }

    public boolean isGreaterThanFour() {
        return this.number >= MOVE_THRESHOLD;
    }
}

package racingcar.car;

import java.util.Objects;
import racingcar.utils.generator.RandomNumberGenerator;

public class MoveNumber {
    public static final int MOVING_FORWARD_LOWER_BOUND = 4;
    private final int number;
    private static final int START_INCLUSIVE = RandomNumberGenerator.START_INCLUSIVE;
    private static final int END_INCLUSIVE = RandomNumberGenerator.END_INCLUSIVE;

    public MoveNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException("전진하는 수는 " + START_INCLUSIVE + "부터 " + END_INCLUSIVE + "사이만 입력할 수 있습니다.");
        }
    }

    public boolean isMovable() {
        return this.number >= MOVING_FORWARD_LOWER_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoveNumber number1 = (MoveNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

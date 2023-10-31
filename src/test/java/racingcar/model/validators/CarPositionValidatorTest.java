package racingcar.model.validators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Exceptions.CarPositionRangeException;


public class CarPositionValidatorTest {

    private final Validator<Integer> validator = new CarPositionValidator();

    @Test
    @DisplayName("자동차 위치의 범위는 0 이상 2,147,483,648 이하의 값이어야 한다.")
    void validateCarPositionRangeOfRandomNumber() {
        Integer negative_one = -1, negative_two = -2;
        Integer zero = 0, hundred = 100, thousand = 1000, million = 10000, max = Integer.MAX_VALUE;
        Integer maxPlusOne = max+1, maxPlusTwo = max+2;

        Assertions.assertThatThrownBy(() -> validator.validate(negative_one)).isInstanceOf(CarPositionRangeException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(negative_two)).isInstanceOf(CarPositionRangeException.class);

        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(zero));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(hundred));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(thousand));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(million));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(max));

        Assertions.assertThatThrownBy(() -> validator.validate(maxPlusOne)).isInstanceOf(CarPositionRangeException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(maxPlusTwo)).isInstanceOf(CarPositionRangeException.class);
    }
}

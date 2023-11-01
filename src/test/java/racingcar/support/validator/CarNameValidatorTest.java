package racingcar.support.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.argument.InvalidCarNameTypeException;
import racingcar.exceptions.argument.OverCarNameLengthLimitException;

class CarNameValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
    void overCarNameLengthLimit() {
        // given
        String carName = "abcdef";

        // when

        // then
        assertThrows(OverCarNameLengthLimitException.class,
            () -> CarNameValidator.validate(carName));
    }

    @Test
    @DisplayName("자동차 이름이 영어가 아닌 경우 예외 발생")
    void notEnglishCarName() {
        // given
        String carName = "가나다라마";

        // when

        // then
        assertThrows(InvalidCarNameTypeException.class,
            () -> CarNameValidator.validate(carName));
    }
}
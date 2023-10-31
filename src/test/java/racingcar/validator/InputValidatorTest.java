package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void validateNameLength() {
        //given
        String carName = "123456";

        //then
        assertThatThrownBy(()->
                InputValidator.validateNameLength(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNamesIsEmpty() {
        //given
        String[] carNames = {};
        //when
        //then
        assertThatThrownBy(()->
                InputValidator.validateCarNamesIsEmpty(carNames)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void validateRepeatNumberIsNumber() {
        //given
        String repeatNumber = "a";

        //then
        assertThatThrownBy(()->
                InputValidator.validateRepeatNumberIsNumber(repeatNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRepeatNumberSign() {
        //given
        Integer repeatNumber = -1;

        //then
        assertThatThrownBy(()->
                InputValidator.validateRepeatNumberSign(repeatNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
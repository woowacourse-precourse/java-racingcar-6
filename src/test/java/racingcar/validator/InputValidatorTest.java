package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void validateNameLength() {
        //given
        String carName = "123456";
        //when

        //then
        assertThatThrownBy(()->
                InputValidator.validateNameLength(carName)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void validateCarNamesIsEmpty() {
    }

    @Test
    void validateRepeatNumberIsNumber() {
    }

    @Test
    void validateRepeatNumberSign() {
    }
}
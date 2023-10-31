package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("이름 길이가 5자를 초과하는 경우")
    void validateNameLength() {
        //given
        String carName = "123456";

        //then
        assertThatThrownBy(()->
                InputValidator.validateNameLength(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 없는 경우")
    void validateCarNamesIsEmpty() {
        //given
        String[] carNames = {};
        //when
        //then
        assertThatThrownBy(()->
                InputValidator.validateCarNamesIsEmpty(carNames)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("반복 횟수가 숫자가 아닌 경우")
    void validateRepeatNumberIsNumber() {
        //given
        String repeatNumber = "a";

        //then
        assertThatThrownBy(()->
                InputValidator.validateRepeatNumberIsNumber(repeatNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("반복 횟수가 0 이하인 경우")
    void validateRepeatNumberSign() {
        //given
        Integer repeatNumber = -1;

        //then
        assertThatThrownBy(()->
                InputValidator.validateRepeatNumberSign(repeatNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
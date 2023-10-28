package racingcar.validate;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarValidateTest {

    @Test
    @DisplayName("자동차 이름이 비어있을 경우 예외가 발생한다.")
    void generateExceptionCarNameIsBlank() {
        //given
        String carName = "";

        //when && then
        assertThatThrownBy(() -> RacingCarValidate.validateCarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과 할 경우 예외가 발생한다.")
    void generateExceptionCarNameLengthExceedFive() {
        //given
        String carName = "a".repeat(6);

        //when && then
        assertThatThrownBy(() -> RacingCarValidate.validateCarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
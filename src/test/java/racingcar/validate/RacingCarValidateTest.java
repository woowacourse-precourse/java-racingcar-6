package racingcar.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarValidateTest {

    @Test
    @DisplayName("자동차 이름이 비어있을 경우 예외가 발생한다.")
    void generateExceptionCarNameIsBlank() {
        //given
        String carName = "";

        //when && then
        Assertions.assertThatThrownBy(() -> RacingCarValidate.validateNameLength(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과 할 경우 예외가 발생한다.")
    void generateExceptionCarNameLengthExceedFive() {
        //given
        String carName = "a".repeat(6);

        //when && then
        Assertions.assertThatThrownBy(() -> RacingCarValidate.validateNameLength(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
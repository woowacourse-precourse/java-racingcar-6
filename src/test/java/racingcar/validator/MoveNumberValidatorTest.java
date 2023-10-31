package racingcar.validator;


import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoveNumberValidatorTest {

    @Test
    void 이동횟수_입력에대한_검증기능_테스트() {
        String notNumber = "qgd";

        assertThatThrownBy(() -> MoveNumberValidator.validate(notNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ENTER_ONLY_NUMBER);

        String minusNumber = "-123";
        assertThatThrownBy(() -> MoveNumberValidator.validate(minusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_ONLY_NUMBER);

        String bigNumber = "111111";
        assertThatThrownBy(() -> MoveNumberValidator.validate(bigNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_PROPER_RANGE_NUMBER);

        String correctNumber = "25";
        MoveNumberValidator.validate(correctNumber);
    }
}
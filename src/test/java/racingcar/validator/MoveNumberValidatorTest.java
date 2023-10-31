package racingcar.validator;


import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoveNumberValidatorTest {

    @Test
    void 자연수가_아닌_이동횟수_검증() {
        String notNumber = "qgd";
        assertThatThrownBy(() -> MoveNumberValidator.validate(notNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ENTER_ONLY_NATURAL_NUMBER);

        String minusNumber = "-123";
        assertThatThrownBy(() -> MoveNumberValidator.validate(minusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_ONLY_NATURAL_NUMBER);
    }

    @Test
    void 이동횟수_값이_한도를_초과할_때() {
        String bigNumber = "111111";
        assertThatThrownBy(() -> MoveNumberValidator.validate(bigNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_PROPER_RANGE_NUMBER);
    }

    @Test
    void 올바른_이동횟수_확인() {
        String correctNumber = "25";
        MoveNumberValidator.validate(correctNumber);
    }
}
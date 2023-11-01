package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.common.ExceptionMessage;

class ValidatorTest {

    @Test
    void 이동_횟수_입력_정상() {
        assertDoesNotThrow(() -> {
            Validator.validateMoveCountNaturalNumber("5");
        });
    }

    @Test
    void 이동_횟수_입력_숫자_아님() {
        String inputNumber = "a";
        assertThatThrownBy(() -> Validator.validateMoveCountNaturalNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @Test
    void 이동_횟수_입력_음수() {
        String inputNumber = "-10";
        assertThatThrownBy(() -> Validator.validateMoveCountNaturalNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NEGATIVE_NUMBER.getMessage());
    }

}
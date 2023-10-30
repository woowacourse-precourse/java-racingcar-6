package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

class InputTryCountTest {
    @Test
    void 양수가_아닐때() {
        String input = "a2f";
        assertThatThrownBy(() -> {
            InputTryCount.isNumeric(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUM_ERROR);
    }

    @Test
    void 양수_일때() {
        String input = "15";
        assertThatCode(() -> {
            InputTryCount.isNumeric(input);
        }).doesNotThrowAnyException();
    }

}
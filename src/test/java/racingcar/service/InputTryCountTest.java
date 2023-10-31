package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

class InputTryCountTest {
    @Test
    void 양수가_아닐때1() {
        String input = "a2f";
        assertThatThrownBy(() -> {
            InputTryCount.isNumeric(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUM_ERROR);
    }

    @Test
    void 양수가_아닐때2() {
        String input = "-1";
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

    @Test
    void 자연수가_아닐때() {
        int input = 0;
        assertThatThrownBy(() -> {
            InputTryCount.checkNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NATURAL_NUM_ERROR);
    }

    @Test
    void 자연수_일때() {
        int input = 20;
        assertThatCode(() -> {
            InputTryCount.checkNumber(input);
        }).doesNotThrowAnyException();
    }
}
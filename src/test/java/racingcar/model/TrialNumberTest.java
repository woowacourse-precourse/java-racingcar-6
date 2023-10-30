package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TrialNumberTest {
    @Test
    void 문자_입력() {
        String input = "핫후라이드";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
    }

    @Test
    void 특수문자_입력() {
        String input = "1+2+3";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
    }

    @Test
    void 공백_포함_입력() {
        String input = "1 2 3";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
    }

    @Test
    void 정수_입력() {
        String input = "123";
        TrialNumber trialNumber = new TrialNumber(input);
        int result = trialNumber.getTrialNumber();

        assertThat(result).isEqualTo(123);
    }

    @Test
    void 소수_입력() {
        String input = "1.2";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
    }

    @Test
    void 음수_입력() {
        String input = "-12";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_NUMBER_MESSAGE.getMessage());
    }

    @Test
    void 입력_0() {
        String input = "000";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_NUMBER_MESSAGE.getMessage());
    }

    @Test
    void 공백_입력() {
        String input = "";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_NAME_ERROR.getMessage());
    }

    @Test
    void 블랭크_입력() {
        String input = " ";
        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_NAME_ERROR.getMessage());
    }
}
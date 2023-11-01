package racingcar.domain.round;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;
import racingcar.error.Roud.InvalidNumberFormatException;
import racingcar.error.Roud.InputUnderOneException;
import racingcar.error.Roud.RoundInputNullException;

class RoundTest {

    String number = "12345";
    String notNumber = "raeㄷㄷ";
    String nullInput = "";
    String zero = "0";

    @Test
    @DisplayName("라운드 카운드 출력 TEST")
    void getRound() {
        Round round = new Round(number);
        assertThat(12345).isEqualTo(round.getRound());
    }

    @Test
    @DisplayName("공백이 입력된 오류 Test")
    void validateRoundNumberCaseInputNull() {
        assertThatThrownBy(() -> new Round(nullInput))
            .isInstanceOf(RoundInputNullException.class)
            .hasMessage(ErrorMessage.ROUND_INPUT_NULL_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("0 이하의 수가 입력된 오류 TEST")
    void validateRoundNumberCaseUnderOne() {
        assertThatThrownBy(() -> new Round(zero))
            .isInstanceOf(InputUnderOneException.class)
            .hasMessage(ErrorMessage.INPUT_UNDER_ONE_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 입력된 오류 TEST")
    void validateRoundNumberCaseNotNumber() {
        assertThatThrownBy(() -> new Round(notNumber))
            .isInstanceOf(InvalidNumberFormatException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT_EXCEPTION.getMessage());
    }
}
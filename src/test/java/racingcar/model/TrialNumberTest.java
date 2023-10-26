package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TrialNumberTest {
    @Test
    void 문자_입력() {
        String input = "핫후라이드";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다.");
    }

    @Test
    void 특수문자_입력() {
        String input = "1+2+3";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다.");
    }

    @Test
    void 공백_포함_입력() {
        String input = "1 2 3";

        assertThatThrownBy(() -> new TrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다.");
    }

    @Test
    void 숫자_입력() {
        String input = "123";
        TrialNumber trialNumber = new TrialNumber(input);
        int result = trialNumber.getTrialNumber();

        assertThat(result).isEqualTo(123);
    }
}
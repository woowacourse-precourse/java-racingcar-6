package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryInputTest {

    @Test
    @DisplayName("입력 받은 시도 횟수를 반환한다.")
    public void tryInputReturn() {
        String tryStr = "5";

        TryInput tryInput = new TryInput(tryStr);

        assertThat(tryInput.getTryCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력 받은 시도 횟수를 반환한다. 유효하지 않은 범위")
    public void tryInput_invalid_num() {
        String tryStr = "0";
        String tryStrMinus = "-1";
        String tryStrMax = String.valueOf(Integer.MAX_VALUE + 1);

        assertThatThrownBy(() -> new TryInput(tryStr))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new TryInput(tryStrMinus))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new TryInput(tryStrMax))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 받은 시도 횟수를 검증한다. 문자가 포함되어 실패")
    public void tryInput_invalid_char() {
        String tryStr = "5x";
        String tryStr1 = "x";

        assertThatThrownBy(() -> new TryInput(tryStr))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new TryInput(tryStr1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
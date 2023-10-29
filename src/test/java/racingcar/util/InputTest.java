package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Cars;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputTest {
    @Test
    @DisplayName("아무것도 입력 안 한 경우")
    void no_enter_check() {
        Assertions.assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수 일치 확인")
    void attempt_count_match() {
        String simulatedInput = "5";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        int attempt = InputView.attemptCount();

        assertThat(attempt).isEqualTo(Integer.parseInt(simulatedInput));
    }
}

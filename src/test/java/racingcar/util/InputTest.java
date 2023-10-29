package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputTest {
    @Test
    @DisplayName("시도횟수 확인")
    void attempt_count() {
        String simulatedInput = "5";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        int attempt = InputView.attemptCount();

        assertThat(attempt).isEqualTo(Integer.parseInt(simulatedInput));
    }
}

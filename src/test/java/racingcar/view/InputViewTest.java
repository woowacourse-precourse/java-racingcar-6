package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @BeforeEach
    void setUp() {
        System.setIn(System.in);
    }

    private void provideInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    @DisplayName("시도 횟수가 숫자로 잘 변환되는지 확인")
    void inputAttemptCount() {
        provideInput("5");
        int attemptCount = InputView.inputAttemptCount();

        assertThat(attemptCount).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 때 예외 처리")
    void inputNonNumericAttemptCount() {
        provideInput("a");

        assertThatThrownBy(() -> {
            int attemptCount = InputView.inputAttemptCount();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("시도 횟수가 1 미만일 때 예외 처리")
    void inputAttemptCountLessThanONE() {
        provideInput("0");

        assertThatThrownBy(() -> {
            int attemptCount = InputView.inputAttemptCount();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 1 이상의 숫자를 입력해주세요.");
    }

}

package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AttemptsTest {
    Attempts attempts;

    @Test
    void 횟수_입력_예외_테스트() {
        assertThatThrownBy(() -> attempts = new Attempts(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_감소_테스트() {
        attempts = new Attempts(3);

        attempts.decreaseAttempts();

        assertThat(attempts.value).isEqualTo(2);
    }

    @Test
    void 횟수_감소_예외_테스트() {
        attempts = new Attempts(1);

        attempts.decreaseAttempts();

        assertThatThrownBy(() -> attempts.decreaseAttempts()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_0_테스트() {
        attempts = new Attempts(1);

        attempts.decreaseAttempts();

        assertThat(attempts.isZero()).isTrue();
    }
}

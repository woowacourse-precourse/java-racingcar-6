package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingAttemptTest {

    @ParameterizedTest
    @ValueSource(strings = {"notANumber", "0", "110"})
    @DisplayName("유효하지 않은 시도 회수값이 주어진 경우 예외를 발생시킨다.")
    void create_failure_throwException(String attemptsString) {
        assertThatThrownBy(() -> new RacingAttempt(attemptsString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "10", "50", "100"})
    @DisplayName("유효한 시도 회수값이 주어진 경우 객체가 정상적으로 생성된다.")
    void create_success(String attemptsString) {
        RacingAttempt racingAttempt = new RacingAttempt(attemptsString);
        Assertions.assertThat(racingAttempt.getAttempts()).isEqualTo(Integer.parseInt(attemptsString));
    }
}

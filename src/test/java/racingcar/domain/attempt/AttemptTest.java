package racingcar.domain.attempt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptTest {

    @Test
    @DisplayName("정수(시도 횟수)를 통해 생성할 수 있다.성")
    void canConstructByInt() {
        // given
        int value = 3;

        // when
        Attempt attempt = new Attempt(value);

        // then
        assertThat(attempt).isExactlyInstanceOf(Attempt.class);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(ints = {0, -1, -2})
    @DisplayName("입력이 1 이하일 경우 IllegalArgumentException을 발생한다.")
    void throwsIllegalArgumentException_whenInputIsUnder1(final int input) {
        final String ERROR_MESSAGE_TOO_LOW = "최소 1 이상의 값을 입력해 주세요.";

        // when, then
        assertThatThrownBy(() -> new Attempt(input))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE_TOO_LOW);
    }

    @Test
    @DisplayName("use() 가 한 번의 시도 횟수를 사용한다.")
    void useOneAttempt_whenUse() {
        // given
        int value = 1;
        Attempt attempt = new Attempt(value);

        // when
        attempt.use();

        // then
        assertThat(attempt.hasNext()).isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 0회 이하일 때 use()를 실행하면 IllegalArgumentException을 발생한다.")
    void throwsIllegalArgumentException_whenAttemptIsUnder0() {
        // given
        final String ERROR_MESSAGE_CANNOT_EXECUTE = "모든 시도 횟수를 소모하셨습니다.";
        int value = 1;
        Attempt attempt = new Attempt(value);
        attempt.use();

        // when, then
        assertThatThrownBy(() -> attempt.use())
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE_CANNOT_EXECUTE);
    }

    @Test
    @DisplayName("hasNext() 가 시도 횟수가 남아있다면 true를 반환한다.")
    void hasNextReturnTrue_whenAttemptRemain() {
        // given
        int value = 3;
        Attempt attempt = new Attempt(value);
        attempt.use();

        // when
        boolean result = attempt.hasNext();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("hasNext() 가 남은 시도 횟수가 없다면 false를 반환한다.")
    void hasNextReturnFalse_whenAttemptNotRemain() {
        // given
        int value = 2;
        Attempt attempt = new Attempt(value);
        attempt.use();
        attempt.use();

        // when
        boolean result = attempt.hasNext();

        // then
        assertThat(result).isFalse();
    }
}
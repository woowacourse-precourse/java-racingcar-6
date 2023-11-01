package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TrialCount;
import racingcar.message.ErrorMessage;

class TrialCountTest {

    @DisplayName("TrialCount 0으로 생성시 IllegalArgumentException 예외를 발생시킨다.)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 999999})
    void trialCountSuccess(int count) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new TrialCount(count));
    }

    @DisplayName("TrialCount 음수로 생성시 IllegalArgumentException 예외를 발생시킨다.)")
    @ParameterizedTest()
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -99999})
    void trialCountException(int count) {
        Assertions.assertThatThrownBy(() -> new TrialCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NEGATIVE);
    }

    @DisplayName("isMoreThen 테스트)")
    @Test
    void moreThen() {
        TrialCount trialCount = new TrialCount(10);

        Assertions.assertThat(trialCount.isMoreThen(9)).isTrue();
        Assertions.assertThat(trialCount.isMoreThen(10)).isFalse();
        Assertions.assertThat(trialCount.isMoreThen(11)).isFalse();
    }
}
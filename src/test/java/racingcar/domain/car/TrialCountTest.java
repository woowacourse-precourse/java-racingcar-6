package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Err;

class TrialCountTest {

    @DisplayName("시도 횟수가 0이거나 음수이면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0, -4, -3})
    void should_Throw_Exception_For_Negative_Value() {
        // given
        int negativeValue = -5;

        // when
        // then
        assertThatThrownBy(() -> TrialCount.from(negativeValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INSUFFICIENT_TRIAL_COUNT.getMessage());
    }

}
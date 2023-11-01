package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TrialNumber;

public class TrialNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 시도횟수_검증_예외발생(int trailNumber) {
        assertThatThrownBy(
                () -> new TrialNumber(trailNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 최소 1회 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 시도횟수_검증_정상(int trailNumber) {
        assertThatCode(
                () -> new TrialNumber(trailNumber))
                .doesNotThrowAnyException();
    }
}
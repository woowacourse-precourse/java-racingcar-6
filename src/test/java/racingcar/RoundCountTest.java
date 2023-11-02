package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RoundCount;

public class RoundCountTest {
    private RoundCount roundCount;

    @ParameterizedTest
    @DisplayName("1이하의 수에 대한 예외 처리")
    @ValueSource(strings = {"0", "-1"})
    void isUnderOne(String string) {
        assertThatThrownBy(() -> roundCount = RoundCount.store(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.23", "56.1"})
    void 정수가_아닌_수에_대한_예외_처리(String string) {
        assertThatThrownBy(() -> roundCount = RoundCount.store(string))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

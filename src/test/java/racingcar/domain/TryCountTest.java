package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Constants;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1abc", "abc1"})
    void 시도_횟수에_문자가_포함됬을경우_예외발생(String count) {
        assertThatThrownBy(() -> new TryCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_TRY_COUNT_NUM);
    }

    @Test
    void 시도_횟수가_1보다_작을경우_예외발생() {
        assertThatThrownBy(() -> new TryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_TRY_COUNT_MIN);
    }

}
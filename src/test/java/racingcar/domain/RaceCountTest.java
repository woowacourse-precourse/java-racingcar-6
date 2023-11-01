package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.response.ErrorCode.RACE_COUNT_INVALID_RANGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("경주 진행 횟수 검증")
class RaceCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 경주_진행_횟수_1보다_작은_정수_예외(int count) {
        // when
        // then
        assertThatThrownBy(() -> new RaceCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACE_COUNT_INVALID_RANGE.getMessage());
    }

    @Test
    void 경주_진행_횟수_생성() {
        // given
        int count = 1;

        // when
        RaceCount result = new RaceCount(count);

        // then
        assertThat(result).isNotNull();
    }
}

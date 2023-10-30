package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @ParameterizedTest
    @DisplayName("TryCount는 0 이상 1000이하에서 정상적으로 생성 테스트")
    @ValueSource(ints = {0, 1000})
    void tryCountCreateTest(int value) {
        // given

        // when
        TryCount tryCount = new TryCount(value);

        // then
        assertThat(tryCount).isEqualTo(new TryCount(value));
    }

    @ParameterizedTest
    @DisplayName("TryCount는 0 미만, 1000 이상에서 IllegalArgumentException 발생 테스트")
    @ValueSource(ints = {-1, 1001})
    void tryCountRangeErrorTest(int value) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new TryCount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 0보다 작거나, 1000보다 클 수 없습니다.");
    }
}

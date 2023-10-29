package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TryCountTest {

    @Test
    @DisplayName("현재의 count를 반환한다.")
    void getCount() {
        TryCount tryCount = TryCount.of(3);
        Assertions.assertThat(tryCount.getCount()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -3})
    @DisplayName("count가 0이하의 정수일 시 에러가 발생한다.")
    void shouldThrowExceptionWhenEmpty(int input) {
        assertThrows(IllegalArgumentException.class, () -> TryCount.of(input));
    }
}
package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.TryCount;

class TryCountTest {
    @Test
    public void 정상_시도횟수() {
        // given
        TryCount tryCount = new TryCount("1");

        // when
        // then
        assertThat(tryCount).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"dbds", "-1"})
    public void 생성_예외(String tryCountString) {
        assertThatThrownBy(() -> new TryCount(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }
}

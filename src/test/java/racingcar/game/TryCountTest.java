package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @Test
    void 시도회수를_생성한다() {
        // given
        TryCount tryCount = new TryCount("5");

        // then
        Assertions.assertThat(tryCount).isEqualTo(new TryCount("5"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", "0"})
    void 잘못된_값을_입력하면_예외가_발생한다(String tryCount) {
        // when
        assertThrows(IllegalArgumentException.class, () ->
                new TryCount(tryCount));
    }
}

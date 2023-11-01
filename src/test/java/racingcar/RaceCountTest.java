package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RaceCount;

public class RaceCountTest {
    @Test
    void from은_시도횟수_숫자를_받아_객체를_반환한다() {
        assertNotNull(RaceCount.from(1));
    }

    @Test
    void init은_시도횟수를_0으로_초기화한_객체를_반환한다() {
        assertNotNull(RaceCount.init());
    }

    @Test
    void 시도횟수가_0이면_예외를_발생한다() {
        assertThatThrownBy(() -> RaceCount.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 시도횟수가_0이_아니면_예외를_발생하지_않는다(int raceCount) {
        assertDoesNotThrow((() -> RaceCount.from(raceCount)));
    }

    @Test
    void increase는_시도횟수를_1씩_증가시킨다() {
        // given
        RaceCount raceCount = RaceCount.from(1);

        // when
        raceCount.increase();
        raceCount.increase();

        // then
        assertEquals(RaceCount.from(3), raceCount);
    }
}

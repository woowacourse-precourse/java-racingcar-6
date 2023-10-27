package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AttemptTest {
    @Test
    void 시도_횟수가_0이하일_경우_예외_반환() {
        assertThatThrownBy(() -> Attempt.from(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Attempt.MINUS_ATTEMPT_IS_NOT_PERMITTED);
    }

    @Test
    void equals_메소드_테스트() {
        Attempt attempt1 = Attempt.from(1);
        Attempt attempt2 = Attempt.from(1);
        assertEquals(attempt1, attempt2);
    }
}
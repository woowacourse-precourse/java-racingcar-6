package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AttemptTest {
    @Test
    void 시도_횟수가_0이하일_경우_예외_반환() {
        assertThatThrownBy(() -> Attempt.withNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Attempt.MINUS_ATTEMPT_IS_NOT_PERMITTED);
    }

    @Test
    void equals_메소드_테스트() {
        Attempt attempt1 = Attempt.withNumber(1);
        Attempt attempt2 = Attempt.withNumber(1);
        assertEquals(attempt1, attempt2);
    }
}
package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0보다 작거나 같다면 예외 발생")
    void createRoundExceptionTest(final int round) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Round.from(round));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("0보다 큰 다면 정상 동작")
    void createRoundTest(final int round) {
        // expected
        assertDoesNotThrow(() -> Round.from(round));
    }

    @Test
    @DisplayName("마지막 라운드가 아니라면 참을 반환")
    void canPlayTest() {
        // given
        Round round = Round.from(1);

        // when
        boolean actual = round.canPlay();

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("마지막 라운드라면 거짓을 반환")
    void canNotPlayTest() {
        // given
        Round round = Round.from(1);
        round.nextRound();

        // when
        boolean actual = round.canPlay();

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("다음 라운드로 이동하는 테스트")
    void nextRoundTest() {
        // given
        Round round = Round.from(1);

        // when
        round.nextRound();

        // then
        int actual = round.getRound();
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("현재 라운드가 마지막 라운드라면 다음 라운드로 이동하지 못하는 테스트")
    void nextRoundExceptionTest() {
        // given
        Round round = Round.from(1);
        round.nextRound();

        // expected
        assertThrows(IllegalStateException.class, round::nextRound);
    }
}
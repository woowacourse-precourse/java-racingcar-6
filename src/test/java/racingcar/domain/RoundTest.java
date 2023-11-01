package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.exception.GameAlreadyFinishedException;
import racingcar.exception.InvalidNumberFormatException;
import racingcar.exception.NonPositiveCountException;

class RoundTest {
    @Test
    public void testConstructorWithValidCount() {
        Round round = new Round("5");
        assertEquals(5, round.getCount());
    }

    @Test
    public void testConstructorWithNonPositiveCount() {
        assertThrows(NonPositiveCountException.class, () -> new Round("0"));
        assertThrows(NonPositiveCountException.class, () -> new Round("-1"));
    }

    @Test
    public void testConstructorWithInvalidFormat() {
        assertThrows(InvalidNumberFormatException.class, () -> new Round("abc"));
        assertThrows(InvalidNumberFormatException.class, () -> new Round("3.5"));
    }

    @Test
    public void testIsFinished() {
        Round round = new Round("1");
        assertFalse(round.isFinished());
        round.finishOneRound();
        assertTrue(round.isFinished());
    }

    @Test
    public void testFinishOneRound() {
        Round round = new Round("2");
        assertEquals(2, round.getCount());
        round.finishOneRound();
        assertEquals(1, round.getCount());
        round.finishOneRound();
        assertEquals(0, round.getCount());
    }

    @Test
    public void testFinishOneRoundAfterGameFinished() {
        Round round = new Round("1");
        round.finishOneRound();
        assertThrows(GameAlreadyFinishedException.class, () -> round.finishOneRound());
    }

}
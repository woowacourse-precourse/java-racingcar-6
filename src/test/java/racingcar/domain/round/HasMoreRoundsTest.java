package racingcar.domain.round;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HasMoreRoundsTest {

    @Test
    @DisplayName("라운드를 더 진행하는가를 판단할 수 있다.")
    void hasMoreRoundsTest() {
        // given
        Round round = new Round(2);

        // when
        boolean hasMoreRoundsAtRound1 = round.hasMoreRounds();
        round.nextRound();
        boolean hasMoreRoundsAtRound2 = round.hasMoreRounds();
        round.nextRound();
        boolean hasMoreRoundsAtRound3 = round.hasMoreRounds();
        round.nextRound();
        boolean hasMoreRoundsAtRound4 = round.hasMoreRounds();

        // then
        Assertions.assertTrue(hasMoreRoundsAtRound1);
        Assertions.assertTrue(hasMoreRoundsAtRound2);

        Assertions.assertFalse(hasMoreRoundsAtRound3);
        Assertions.assertFalse(hasMoreRoundsAtRound4);
    }

}
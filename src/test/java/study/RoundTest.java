package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.round.Round;

public class RoundTest {
    private Round round;

    @BeforeEach
    void setUp() {
        round = new Round(5);
    }

    @Test
    void initiate_round() {
        assertThat(round.hasReachedFinalRound()).isFalse();
    }

    @Test
    void has_not_reached_final_round() {
        round.proceedToNextRound();
        assertThat(round.hasReachedFinalRound()).isFalse();
    }

    @Test
    void reached_final_round() {
        for (int i = 0; i < 5; i++) {
            round.proceedToNextRound();
        }

        assertThat(round.hasReachedFinalRound()).isTrue();
    }

    @Test
    void proceed_beyond_final_round() {

        for (int i = 0; i < 5; i++) {
            round.proceedToNextRound();
        }

        assertThatThrownBy(round::proceedToNextRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No more rounds left.");
    }
}

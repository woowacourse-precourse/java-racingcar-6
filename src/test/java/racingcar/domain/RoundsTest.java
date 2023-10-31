package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RoundsTest {
    private Rounds rounds = new Rounds();

    @Test
    void 원하는_개수대로_round가_생성이_되는지_확인한다() {
        Integer expected = 3;

        rounds.makeRounds(expected);
        Integer actual = rounds.getRounds().size();

        assertThat(actual).isEqualTo(expected);
    }
}
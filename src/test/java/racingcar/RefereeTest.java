package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    Referee referee = new Referee();

    @Test
    void 심판이_자동차가_정지하도록_판단한_경우() {
        final int LOWER_NUMBER_THAN_FOUR = 3;

        Assertions.assertThat(referee.judgeMoveOrStop(LOWER_NUMBER_THAN_FOUR)).isEqualTo(false);
    }

    @Test
    void 심판이_자동차가_전진하도록_판단한_경우() {
        final int HIGHER_NUMBER_THAN_FOUR = 5;

        Assertions.assertThat(referee.judgeMoveOrStop(HIGHER_NUMBER_THAN_FOUR)).isEqualTo(true);
    }
}

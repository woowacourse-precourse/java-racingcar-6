package racingcar.domain.dto.round;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.round.Round;

final class RoundTest {

    @DisplayName("")
    @Test
    void test() {
        // given
        final Round round = new Round(1);
        final Round round2 = new Round(3);

        // when
        final Round increased = round.increased();

        // then
        assertThat(increased.isNotAfter(round2))
                .isTrue();
    }

}
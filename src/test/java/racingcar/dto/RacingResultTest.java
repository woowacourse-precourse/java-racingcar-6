package racingcar.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingResultTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 전진횟수만큼_position_길이가_증가한다(int movedCount) {
        // given
        String name = "test";
        RacingResult racingResult = new RacingResult(name, movedCount);

        // when
        int actual = racingResult.position().length();

        // then
        assertThat(actual).isEqualTo(movedCount);
    }
}
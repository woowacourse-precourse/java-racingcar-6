package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;

class InputConvertorTest {

    @Test
    @DisplayName("자동차_이름_전환_테스트")
    void toRacingCars() {
        String input = "pobi,woni,jun";

        RacingCars racingCars = InputConvertor.toRacingCars(input);

        Assertions.assertThat(racingCars.getCars())
                .extracting("name")
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("움직임_횟수_전환_테스트")
    void toMoveCount() {
        String input = "13";

        Assertions.assertThat(InputConvertor.toMoveCount(input)).isEqualTo(13);
    }
}
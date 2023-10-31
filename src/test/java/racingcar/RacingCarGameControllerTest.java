package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarGameControllerTest {

    @Test
    void 자동차_이름_길이_테스트() {

        RacingCarGameController.checkCarNamesLength("pobi,woni".split(","));

        Assertions.assertThatThrownBy(() -> {
            RacingCarGameController.checkCarNamesLength("pobiwoni,jun".split(","));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_숫자_테스트() {

        long numOfMoves = RacingCarGameController.parseNumOfMoves("5");
        Assertions.assertThat(numOfMoves).isEqualTo((long)5);

        Assertions.assertThatThrownBy(() -> {
            RacingCarGameController.parseNumOfMoves("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
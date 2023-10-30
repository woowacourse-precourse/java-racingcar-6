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
}
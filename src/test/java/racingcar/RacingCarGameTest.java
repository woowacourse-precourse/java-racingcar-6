package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    @DisplayName("자동차 이름 나누기 테스트")
    void 자동차_이름_나누기_테스트() {
        String carName = "pobi,jun,wooni";
        List<String> carNameList = Arrays.asList("pobi", "jun", "wooni");

        racingCarGame.splitCarName(carName);

        assertThat(racingCarGame.getCarNameList()).isEqualTo(carNameList);
    }
}
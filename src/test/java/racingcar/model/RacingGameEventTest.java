package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameEventTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    public void createRacingCarTest() {
        String[] cars = {"pobi", "woni", "jun"};
        RacingGameEvent racingGameEvent = new RacingGameEvent(cars);
        Assertions.assertThat(racingGameEvent.getPositionHistory().size()).isEqualTo(3);
    }
}
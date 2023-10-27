package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void stopOrMoveDecisionTest() {
        //given
        Car car = new Car("hoho");
        String testResult = "-";

        //when
        car.stopOrMoveDecision(5);

        //then
        Assertions.assertThat(car).extracting("position").isEqualTo(1);

    }
}
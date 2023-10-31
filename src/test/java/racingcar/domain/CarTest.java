package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void stopOrMoveDecisionTest() {
        //given
        Car car = new Car("hoho");

        //when
        car.move(5);

        //then
        Assertions.assertThat(car).extracting("position").isEqualTo(1);
    }
}
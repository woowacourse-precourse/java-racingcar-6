package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void move_이동_또는_정지() throws Exception {
        //given
        Car car1 = new Car("car1");

        //when
        car1.move();

        //then
        Assertions.assertThat(car1.getMovedDist()).isBetween(0, 1);
    }
}
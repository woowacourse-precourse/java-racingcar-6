package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    public void 자동차_전진_조건_부합() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(4);
        car.moveForward(5);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 자동차_전진_조건_미달() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(2);
        car.moveForward(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}

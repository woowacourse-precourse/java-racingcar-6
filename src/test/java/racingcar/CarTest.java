package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    public void 테스트_자동차_전진() {
        // given
        Car car = new Car("Car1");
        // when
        car.moveForward();
        // then
        assertEquals(1, car.getForward());
        assertThat(1).isEqualTo(car.getForward());
    }

    @Test
    public void 테스트_자동차_이름() {
        // given
        Car car = new Car("pobi");
        // when
        String name = car.getName();
        // then
        assertEquals(name, car.getName());
        assertThat(name).isEqualTo("pobi");
    }
}

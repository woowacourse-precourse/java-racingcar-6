package custom;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차_전진")
    public void 자동차_전진() throws Exception {
        //given
        Car car = new Car();

        //when
        car.forward();

        //then
        assertThat(car.getDistance()).isEqualTo("-");
    }
}

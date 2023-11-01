package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 값이_4_이상_전진() {
        Car car = new Car("pobi");
        boolean isMovable_4 = car.isMovable(4);
        assertThat(isMovable_4).isTrue();
        boolean isMovable_5 = car.isMovable(5);
        assertThat(isMovable_5).isTrue();
    }

    @Test
    void 값이_3_이하_정지() {
        Car car = new Car("pobi");
        boolean isMovable_3 = car.isMovable(3);
        assertThat(isMovable_3).isFalse();
        boolean isMovable_2 = car.isMovable(2);
        assertThat(isMovable_2).isFalse();
    }
}

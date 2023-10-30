package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("car 전진시 position 증가 테스트")
    @Test
    void moveForwardTest() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");

        car1.moveForward(true);
        car2.moveForward(false);

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }
}
package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 전진_확인() {
        Car car = new Car("yen");
        car.moveFoward(4);
        int result = car.getNumberOfMove();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 전진_안_하는_것_확인() {
        Car car = new Car("yen");
        car.moveFoward(1);
        int result = car.getNumberOfMove();

        assertThat(result).isEqualTo(0);
    }
}

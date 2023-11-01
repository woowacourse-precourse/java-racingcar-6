package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 랜덤값이_4_이상일때_전진한다() {
        Car car = new Car(new CarName("pobi"));
        assertThat(car.move(5)).isTrue();
    }
}

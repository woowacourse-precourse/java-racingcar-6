package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 전진_후_정보_출력_테스트() {
        Car car = new Car("test");

        car.move();

        assertThat(car.toString()).isEqualTo("test : -");
    }
}

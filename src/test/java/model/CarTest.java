package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    // getPosition() 테스트
    @Test
    void 전진_할_때_1씩_증가하는지_확인() {
        // given
        Car car = new Car("pobi");

        // when
        car.forward();
        car.forward();
        car.forward();

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }
}

package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 랜덤_값이_4_이상일_경우_전진한다() {
        // given
        Car car = new Car("test");

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 값이_4보다_작다면_전진하지_않는다() throws Exception {
        // given
        Car car = new Car("test");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
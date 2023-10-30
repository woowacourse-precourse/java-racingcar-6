package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        //given
        Car car = new Car("judy");
        //when
        car.move(4);
        //then
        assertThat(car.getPosition()).isEqualTo(1);

    }
}
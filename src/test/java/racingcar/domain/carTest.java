package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        //given
        Car car = new Car("mino");
        //when
        car.move(5);
        //then
        assertThat(car.getPosition()).isEqualTo(1);

    }
}
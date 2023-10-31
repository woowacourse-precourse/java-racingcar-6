package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void move_테스트() throws Exception {
        //given
        Car car = new Car("car1", 3);

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(4);
    }

}
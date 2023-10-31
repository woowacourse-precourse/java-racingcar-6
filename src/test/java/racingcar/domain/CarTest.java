package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_랜덤값_4이상_이동(){
        //given
        Car car = new Car("유정");
        int random1 = 5;
        Car car2 = new Car("유정이");
        int random2 = 9;

        //when
        car.move(random1);
        car2.move(random2);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_랜덤값_4미만_미이동(){
        //given
        Car car = new Car("유정");
        int random1 = 3;
        Car car2 = new Car("유정이");
        int random2 = 2;

        //when
        car.move(random1);
        car2.move(random2);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);

    }
}
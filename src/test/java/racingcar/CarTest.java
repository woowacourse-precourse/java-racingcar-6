package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void car_전진_기준숫자와_같거나_더_클때_position_1증가() {
        Car car = new Car("testCar1");
        car.moving(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    void car_정지_기준숫자보다_더_작을때_position_증가없음() {
        Car car = new Car("testCar2");
        car.moving(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    void car_주행상태_바문자열_position만큼_리턴() {
        Car car = new Car("testCar3", 4);
        assertEquals("testCar3 : ----", car.getNowCarPosition());
    }


}

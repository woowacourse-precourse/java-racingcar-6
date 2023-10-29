package racingcar.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final static int MOVING_STANDARD = 4;
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("test");
    }


    @Test
    void move_기준값이상일때_1칸전진() {
        int location = car.move(4);
        assertThat(location).isEqualTo(1);
    }

    @Test
    void move_기준값미만일때_정지() {
        int location = car.move(2);
        assertThat(location).isEqualTo(0);
    }
}
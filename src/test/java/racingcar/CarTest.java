package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCarMoving() {
        Car car = new CarImpl();

        //내부 무작위 값이 0~3 사이의 값일 때 이동하는가?
        car.goOrStop(0,3);
        assertThat(car.getLocation()).isEqualTo(0);

        //내부 무작위 값이 4일때 이동하는가?
        car.goOrStop(4,4);
        assertThat(car.getLocation()).isEqualTo(1);

        //내부 무작위 값이 5~9 사이의 값일 때 이동하는가?
        car.goOrStop(5,9);
        assertThat(car.getLocation()).isEqualTo(2);
    }
}
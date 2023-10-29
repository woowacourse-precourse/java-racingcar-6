package racingcar.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private final static int MOVING_STANDARD = 4;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void Car_이름길이5이상_인스턴스생성실패() {
        String wrongName = "longerthan5";
        assertThatThrownBy(() ->
                new Car(wrongName)).isInstanceOf(IllegalStateException.class);
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
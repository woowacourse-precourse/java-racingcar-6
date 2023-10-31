package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void 기본_설정_셋팅() {
        car = new Car("Car1");
    }

    @Test
    void getName_메소드_검사() {
        assertThat(car.getName()).isEqualTo("Car1");
    }

    @Test
    void getDistance_메소드_검사() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진_기능_검사() {
        car.moveForward();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}


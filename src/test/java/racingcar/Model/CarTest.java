package racingcar.Model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void createCarWithValidName() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    public void createCarWithInvalidName_ShouldThrowException() {
        assertThatThrownBy(() -> {
            new Car("invalidname");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void moveCarByRandomValue() {
        Car car = new Car("test");
        car.move(4); // 4 이상의 값은 전진
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(3); // 3 이하는 멈춤
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

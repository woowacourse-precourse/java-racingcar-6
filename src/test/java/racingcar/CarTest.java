package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @Test
    void 차_생성() {
        Car car = new Car("test");
        assertThat(car).isNotNull();
    }

    @Test
    void 이름_5자이상_예외발생() {
        assertThatThrownBy(() -> new Car("tooLongName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_전진() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 차_정지() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}

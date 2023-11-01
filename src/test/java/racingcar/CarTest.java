package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car;

    @Test
    public void 자동차_이름_유효성_테스트() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("lucky5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이동_테스트() {
        car = new Car("luda");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_객체_테스트() {
        car = new Car("luda");
        assertThat(car.getName()).isEqualTo("luda");
    }
}

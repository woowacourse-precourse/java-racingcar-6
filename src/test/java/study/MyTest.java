package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import racingcar.Car;
import racingcar.CarController;

public class MyTest {

    @Test
    public void 자동차_전진_테스트() {
        // given
        Car car1 = new Car("apple");
        Car car2 = new Car("melon");
        // when
        car1.moveCar();
        // then
        assertThat(car1.getForwardMoveCount()).contains("apple : -");
    }

    @Test
    public void 자동차_이름_제한보다_긴_이름_입력할_때_예외_발생() {
        String[] carNames = {"apple", "banana", "melon"};

        assertThatThrownBy(() -> new CarController(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

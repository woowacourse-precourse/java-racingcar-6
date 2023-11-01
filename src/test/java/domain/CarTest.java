package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    void 자동차_이름이_다섯_글자가_넘으면_예외를_던진다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
    }

    @Test
    void 주어진_숫가자_4이상이면_전진한다() {
        Car car1 = new Car("박정언");
        Car car2 = new Car("홍길동");

        car1.moveOrStop(4);

        assertThat(car1.isSamePosition(car2)).isFalse();
    }

    @Test
    void 주어진_숫자가_4미만이면_전진하지_않는다() {
        Car car1 = new Car("박정언");
        Car car2 = new Car("홍길동");
        car1.moveOrStop(3);

        assertThat(car1.isSamePosition(car2)).isTrue();
    }

    @Test
    void 같은_포지션의_자동차를_찿는다() {
        Car car1 = new Car("박정언");
        Car car2 = new Car("홍길동");

        car1.moveOrStop(4);
        car2.moveOrStop(4);

        assertThat(car1.isSamePosition(car2)).isTrue();
    }
}

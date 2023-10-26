package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    void 자동차_이름_5자초과_예외처리_테스트() {
        assertThatThrownBy(() -> new Car("송민준입니다")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차_이름_0자_예외처리_테스트() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }
}

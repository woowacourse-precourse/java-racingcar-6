package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 기능 검증")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("name");
    }

    @Test
    void 자동차_정지() {
        // given
        boolean isMove = false;

        // when
        car.move(isMove);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진() {
        // given
        boolean isMove = true;

        // when
        car.move(isMove);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

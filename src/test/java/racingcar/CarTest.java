package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_초기_위치는_0() {
        assertThat(new Car("pobi").getPosition()).isZero();
    }
}

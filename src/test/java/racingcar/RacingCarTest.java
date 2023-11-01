package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차_생성() {
        RacingCar racingCar = new RacingCar("jihun");

        assertEquals("jihun", racingCar.getName());
    }

    @Test
    void 자동차_이름은_5자이하_예외_처리() {
        assertThatThrownBy(() -> new RacingCar("jihun_woowa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
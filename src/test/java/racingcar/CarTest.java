package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_생성() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

    @Test
    void 이름_길이_검증() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Car("pobipobi"));
        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.getMessage());
    }
}

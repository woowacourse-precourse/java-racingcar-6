package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
    @Test
    void constructorInvalidCarName_exception_test() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("abcdef"));
    }
}

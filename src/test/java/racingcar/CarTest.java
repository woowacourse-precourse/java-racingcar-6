package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름이_5자_이내인_경우() {
        Assertions.assertDoesNotThrow(() -> new Car("a"));
    }

}

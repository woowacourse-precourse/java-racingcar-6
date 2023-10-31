package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void tryMove() {
        Car test = new Car("test", 0);
        test.tryMove(6);
        Assertions.assertThat(test.getMoveNum()).isEqualTo(1);
    }
}
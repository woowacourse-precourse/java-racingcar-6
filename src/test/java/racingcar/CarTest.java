package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_이름이_5자_이내인_경우() {
        Assertions.assertDoesNotThrow(() -> new Car("a"));
    }

    @Test
    void 자동차_이름이_5자_넘는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("abcdefg"));
    }

    @Test
    void 자동차가_전진한_경우() {
        final Car car = new Car("a");

        int before = car.getTotalMoveLen();
        car.moveOrStop(true);
        int after = car.getTotalMoveLen();

        assertThat(before + 1).isEqualTo(after);
    }
}

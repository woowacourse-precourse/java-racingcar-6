package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void validateCarName_자동차_이름이_5자_이내인_경우() {
        Assertions.assertDoesNotThrow(() -> new Car("a"));
    }

    @Test
    void validateCarName_자동차_이름이_5자_넘는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("abcdefg"));
    }

    @Test
    void moveOrStop_자동차가_전진한_경우() {
        final Car car = new Car("a");

        int before = car.getTotalMoveLen();
        car.moveOrStop(true);
        int after = car.getTotalMoveLen();

        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void moveOrStop_자동차가_정지한_경우() {
        final Car car = new Car("a");

        int before = car.getTotalMoveLen();
        car.moveOrStop(false);
        int after = car.getTotalMoveLen();

        assertThat(before).isEqualTo(after);
    }
}

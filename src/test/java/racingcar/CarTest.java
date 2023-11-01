package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest{

    @Test
    void 전진할때_횟수가_증가하는지() {
        // given
        Car car = new Car("pobi", 1);

        // when
        car.moveForward();

        // then
        int result = car.getMoveForwardCount();
        Assertions.assertThat(result).isEqualTo(2);
    }
}
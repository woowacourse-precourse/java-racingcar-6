package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    RacingCar racingCar = new RacingCar("test");

    @Test
    void 이동_가능_테스트_() {

        boolean canMove = racingCar.canMove(4);
        boolean cannotMove = racingCar.canMove(3);

        Assertions.assertThat(canMove).isTrue();
        Assertions.assertThat(cannotMove).isFalse();
    }

    @Test
    void 이동_횟수_테스트() {

        String result;

        racingCar.move(3);
        result = racingCar.makeResult();
        Assertions.assertThat(result).isEqualTo("");

        racingCar.move(5);
        result = racingCar.makeResult();
        Assertions.assertThat(result).isEqualTo("-");

        racingCar.move(5);
        result = racingCar.makeResult();
        Assertions.assertThat(result).isEqualTo("--");
    }

    @Test
    void 결과_테스트() {

        racingCar.move(5);
        racingCar.move(5);
        String result = racingCar.reportResult();
        Assertions.assertThat(result).isEqualTo("test : --");
    }
}
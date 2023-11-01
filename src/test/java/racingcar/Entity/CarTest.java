package racingcar.Entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int GO = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차_전진__step값_검증")
    void run_메서드_실행후_step값_검증() {
        Racer car = Car.create("cc", 1);

        assertRandomNumberInRangeTest(
                () -> {
                    car.run();
                    assertThat(car.getLocation()).isEqualTo(1);
                    car.run();
                    assertThat(car.getLocation()).isEqualTo(2);
                },
                STOP, GO
        );
    }
}
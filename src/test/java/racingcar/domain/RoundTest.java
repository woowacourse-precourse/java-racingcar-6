package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.TestCommon;

class RoundTest extends TestCommon {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Round round;
    private Cars cars;

    @BeforeEach
    void testInit() {
        round = new Round();
        cars = new Cars();
    }

    @Test
    void 한차수의_실행결과_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.registerCar("pobi,woni");
                    round.start(cars);
                    assertThat(getOutput()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }
}
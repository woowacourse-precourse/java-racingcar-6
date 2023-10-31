package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarRacingAdminTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_경주_전체_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("bae,sue", "2");
                    assertThat(output()).contains("bae : -", "sue : ",
                            "bae : --", "sue : -",
                            "최종 우승자 : bae");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        CarRacingAdmin carRacingAdmin = new CarRacingAdmin();
        carRacingAdmin.startRace();
    }
}

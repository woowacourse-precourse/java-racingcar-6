package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ModelTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    RacingGame gameTest = new RacingGame();

    @DisplayName("어플리케이션 실행 테스트")
    @Test
    void applicationTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("steph,woni", "1");
                    assertThat(output()).contains("steph : -", "woni : ", "최종 우승자 : steph");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

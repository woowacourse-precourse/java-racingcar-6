package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class progressTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void progress() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -");
                },
                STOP , MOVING_FORWARD
        );
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}

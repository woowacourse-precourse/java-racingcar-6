package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.util.message.SystemMessage;

public class MessagePrintTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 경주_안내_메시지_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(SystemMessage.INPUT_CAR_NAME_MESSAGE.getMessage());
                    assertThat(output()).contains(SystemMessage.INPUT_TRIAL_MESSAGE.getMessage());
                    assertThat(output()).contains(SystemMessage.RESULT_HEADER_MESSAGE.getMessage());
                },
                MOVING_FORWARD, STOP
        );

    }

    @Test
    void 올바른_경주_진행상황_메시지_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "pobi : --", "pobi : ---");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

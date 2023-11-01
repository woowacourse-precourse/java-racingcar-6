package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest  extends NsTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @Test()
    void 경주_세번_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("one,two", "3");
                    assertThat(output()).contains("one : -", "two : ", "one : -", "two : ", "one : --", "two : ", "최종 우승자 : one");
                },
                MOVE, STOP, STOP, STOP, MOVE, STOP
        );

    }


    public void runMain() {
        Application.main(new String[]{});
    }

}
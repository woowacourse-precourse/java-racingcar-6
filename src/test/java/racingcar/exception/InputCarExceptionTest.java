package racingcar.exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputCarExceptionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름_5자_이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,siyeon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_자동차의_개수가_1개_이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_제거() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni, jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,Kim SY", "1");
                    assertThat(output()).contains("pobi : ", "KimSY : -", "최종 우승자 : KimSY");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
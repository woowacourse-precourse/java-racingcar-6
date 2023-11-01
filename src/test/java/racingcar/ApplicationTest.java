package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_빈칸일_때의_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,a,b"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름이_기호일_때의_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름이_같을_때의_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jake,jake"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름이_개행일_때의_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

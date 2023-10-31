package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void 이름에_대한_예외_처리_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_6자이상_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("seungjae,jun,july", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_특수기호_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("@#,jail,#%", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_쉼표2번_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hill,name,seung,,hun", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_중복_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hill,name,hill,hi", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도회수에_대한_예외_처리_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hill,name,seung,hun", "cake"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도회수에_대한_예외_처리_음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hill,name,seung,hun", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

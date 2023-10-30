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
    void 차_두대_승자_한_명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 차_두대_승자_두명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 차_세대_승자_세명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hjb", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "hjb : --", "최종 우승자 : pobi, woni, hjb");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 차_세대_승자_두명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hjb", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "hjb : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름이_white_space_포함() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po b  i,w   o   n  i", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 유효성_검사_이름이_5자_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효성_검사_실행회수_숫자아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1ab8d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효성_검사_실행회수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 유효성_검사_실행회수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효성_검사_이름이_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효성_검사_이름이_공백문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("     ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효성_검사_이름이_공백문자_포함_5자_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("t, 3  5  ㅇ  ㅇ ㅏ   k", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

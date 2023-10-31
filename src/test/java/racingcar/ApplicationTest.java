package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void ㄱ_자동차_입력받기_일반() {
        String inputCars = "pobi,woni,hjb,java,spri";
        String inputPlayTime = "1";

        run(inputCars, inputPlayTime);
        assertThat(output()).contains("pobi, woni, hjb, java, spri");
        assertThat(output()).contains("1");
    }

    @Test
    void ㄴ1_자동차_입력받기_이름이_5자_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄴ2_자동차_입력받기_이름이_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄴ3_자동차_입력받기_이름이_공백문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("     ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄴ4_자동차_입력받기_이름이_공백문자_미포함_5자_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("t, 3  5  ㅇ  ㅇ ㅏ   k", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄷ1_자동차_입력받기_실행회수_숫자아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1ab8d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄷ3_자동차_입력받기_실행회수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄷ4_자동차_입력받기_실행회수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ㄹ1_전진내용_갱신_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    assertThat(output()).contains("-", "--");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void ㄹ2_전진내용_갱신_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : \n");
                },
                STOP
        );
    }

    @Test
    void ㅁ_전진내용_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -\nwoni : -", "pobi : -\nwoni : --");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void ㅂ1_단일승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void ㅂ2_단일승자_reverse_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("woni,pobi", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void ㅅ1_다수승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void ㅅ2_다수승자_reverse_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("woni,pobi", "1");
                    assertThat(output()).contains("최종 우승자 : woni, pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void ㅇ1_실행결과_차_세대_승자_세명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hjb", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "hjb : --", "최종 우승자 : pobi, woni, hjb");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void ㅇ2_실행결과_차_세대_승자_두명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hjb", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "hjb : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

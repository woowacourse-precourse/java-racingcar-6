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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 이름_입력_알림() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    String[] split = output().split("\n");
                    assertThat(split[0]).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 이름_정상동작_쉼표_마지막() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,", "2");
                    assertThat(output()).contains("pobi : --", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이동횟수_입력_알림() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    String[] split = output().split("\n");
                    assertThat(split[1]).isEqualTo("시도할 회수는 몇회인가요?");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 이동횟수에_대한_예외_처리_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,mimi", "hi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동횟수에_대한_예외_처리_범위() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,mimi", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동횟수에_대한_예외_처리_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,mimi", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_정지_누적() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전진_정지_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "3");
                    assertThat(output()).contains("pobi : -", "pobi : --");
                    assertThat(output()).doesNotContain("pobi : ---");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 정지_전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "3");
                    assertThat(output()).contains("pobi : ", "pobi : -");
                    assertThat(output()).doesNotContain("pobi : --");
                },
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    String[] split = output().split("\n");
                    assertThat(split[split.length-1]).isEqualTo("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}

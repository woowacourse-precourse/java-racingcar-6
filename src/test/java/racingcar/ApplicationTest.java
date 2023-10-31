package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int SAME_VALUE = 5;

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
    void 이름에_대한_예외_처리_5자초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_0자() {
         assertSimpleTest(() ->
                 assertThatThrownBy(() -> runException("", "1"))
                         .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 반복횟수에_대한_예외_처리_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("poby,jun", "0"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 반복횟수에_대한_예외_처리_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("poby,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 반복횟수에_대한_예외_처리_숫자아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("poby,jun", "cat"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 우승자_다수_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi,woni");
                },
                SAME_VALUE, SAME_VALUE
        );
    }

    @Test
    void 상태_저장_테스트() {
        Map<String, Integer> status = new HashMap<>();
        status.put("pobi", 0);
        status.put("woni", 0);

        assertRandomNumberInRangeTest(
                () -> {
                    Game.play(status, 1);
                    assertThat(status).containsEntry("pobi", 1);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

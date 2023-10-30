package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class MyTest extends NsTest {
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
    void 이름_길이_오류에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qudcks8084", "1"))
                        .isInstanceOf((IllegalArgumentException.class))
        );
    }

    @Test
    void 라운드_횟수에_0이_들어간_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Alice,Bob", "0"))
                        .isInstanceOf((IllegalArgumentException.class))
        );
    }

    @Test
    void 중복_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Alice,Alice", "2"))
                        .isInstanceOf((IllegalArgumentException.class))
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

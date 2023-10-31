package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 전진_정지_2() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "2");
            assertThat(output()).contains("pobi : -", "woni : ", "pobi : -", "woni : ", "최종 우승자 : pobi, woni");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }


    @Test
    void 이름에_대한_예외_처리_3() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 빈_이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("", "1")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 회수에_대한_예외_처리_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "영")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format("%d글자 이하", Common.CAR_NAME_MAX_LENGTH.getIntValue()))
        );
    }

    @Test
    void 회수에_대한_예외_처리_3() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,java", "qwe"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

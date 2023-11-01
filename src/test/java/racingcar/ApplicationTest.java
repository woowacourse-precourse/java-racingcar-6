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

    /* 공백에도 예외 처리를 하면 프로그램이 딱딱해보일 수 있기에 공백을 제거하는 방식으로 처리 */
    @Test
    void 이름에_공백이_포함되었을_때() {
        assertRandomNumberInRangeTest(
            () -> {
                run(" pobi, woni ", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    /* 예외 처리 테스트 */
    @Test
    void 이름이_입력되지_않을때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 이름이 없습니다.")
        );
    }

    @Test
    void 이름에_숫자가_입력되었을때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 이름이 숫자입니다.")
        );
    }

    @Test
    void 이름이_하나만_입력되었을때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 이름이 한 개입니다.")
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("5자를 초과한 이름이 존재합니다.")
        );
    }

    @Test
    void 시행횟수로_0이_입력되었을때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 숫자가 0입니다.")
        );
    }

    @Test
    void 시행횟수로_음수가_입력되었을때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 숫자가 음수입니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

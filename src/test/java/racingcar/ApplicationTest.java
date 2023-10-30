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

    // Writing SeolHuiGwan9478 Integration Test Code
    @Test
    void 이름_공백_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,    woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid space condition")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni   ,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid space condition")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid space condition")
        );
    }

    @Test
    void 이름_null_값_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Car Name is Null")
        );
    }

    @Test
    void 자동차_최소_개수_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid the minimum number of cars")
        );
    }

    @Test
    void 이름_최소_길이_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid name length")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid name length")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid name length")
        );
    }

    @Test
    void 이름_최대_길이_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,seolhuigwan", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid name length")
        );
    }

    @Test
    void 이동_횟수_null_값_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,woni,jun", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: moveCount is Null")
        );
    }

    @Test
    void 이동_횟수_공백_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,woni,jun", " 1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: moveCount is not numeric")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,woni,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: moveCount is not numeric")
        );
    }

    @Test
    void 이동_횟수_최소_횟수_예외_처리(){
        // given
        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobie,woni,jun", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input Error: Invalid the minimum number of moveCount")
        );
    }

    @Test
    void 전진_정지_예시(){
        // given
        // when
        run("pobie,woni,jun", "5");
        // then
        assertThat(output()).contains("최종 우승자 : ");
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

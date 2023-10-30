package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("입력한 이름에 중복이 있는 경우 예외가 발생한다.")
    @Test
    void 이름에_대한_중복_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력한 이름에 빈 값이 있는 경우 예외가 발생한다.")
    @Test
    void 이름에_대한_빈값_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수에 대한 입력이 0인 경우 예외가 발생한다.")
    @Test
    void 시도_횟수_0에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pinut,pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수에 대한 입력이 문자인 경우 예외가 발생한다.")
    @Test
    void 시도_횟수_문자에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pinut,pobi", "C"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수에 대한 입력이 빈 값인 경우 예외가 발생한다.")
    @Test
    void 시도_횟수_빈값에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pinut,pobi", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

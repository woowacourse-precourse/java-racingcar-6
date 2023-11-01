package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("최종 우승자가 한 명인 경우")
    @Test
    void 전진_정지_1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @DisplayName("최종 우승자가 여러 명인 경우")
    @Test
    void 전진_정지_2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @DisplayName("이름이 6자 이상이면 예외가 발생한다.")
    @Test
    void 이름에_대한_예외_처리_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이름이 쉼표로 구분되어 있지 않으면 예외가 발생한다.")
    @Test
    void 이름에_대한_예외_처리_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi java", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void 시도횟수에_대한_예외_처리_1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, java", "k"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수에 0 이하의 값을 입력하면 예외가 발생한다.")
    @Test
    void 시도횟수에_대한_예외_처리_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, java", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

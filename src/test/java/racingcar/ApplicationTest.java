package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.MockedStatic.Verification;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mockStatic;

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
    void 아무도_전진을_못했다면(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("jun, hee", "1");
                    assertThat(output()).contains("jun : ", "hee : ", "최종 우승자 : jun, hee");
                },
                STOP, STOP
        );
    }

    @Test
    void 모두_같은_위치에_있다면(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("jun, hee", "3");
                    assertThat(output()).contains("jun : --", "hee : --", "최종 우승자 : jun, hee");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
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
    void 이름에_공백이_들어오면_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   , junhe", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @Test
    void 중복된_이름이_들어오면_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jun, lee, jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 아무것도_입력되지_않으면_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주_횟수에_정수가_아닌_다른_자료형이_들어오면_예외_처리() {
        String input = "k";

        assertThatThrownBy(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

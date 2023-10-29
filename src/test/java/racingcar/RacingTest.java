package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static racingcar.util.ErrorMessage.*;

public class RacingTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 정상_동작_테스트() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "2");
                    assertThat(output()).contains(
                            "a : -", "b : -",
                            "a : --", "b : -",
                            "최종 우승자 : a"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_길이_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LENGTH_ERROR.getMessage())
        );
    }

    @Test
    void 이름_공백_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BLANK_ERROR.getMessage())
        );
    }

    @Test
    void 이름_숫자_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,1", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NO_NUMERIC_ERROR.getMessage())
        );
    }

    @Test
    void 중복_이름_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "2147483647"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_NAME_ERROR.getMessage())
        );
    }

    @Test
    void 영_횟수_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,name", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NEGATIVE_NUMBER_ERROR.getMessage())
        );
    }

    @Test
    void 음수_횟수_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,name", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NEGATIVE_NUMBER_ERROR.getMessage())
        );
    }

    @Test
    void 너무_큰_시도_횟수_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,name", "2147483647"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_NUMBER_ERROR.getMessage())
        );
    }

    @Test
    void 특수_문자_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.name", "2147483647"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(SPLIT_REGEX_ERROR.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

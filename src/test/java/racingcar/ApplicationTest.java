package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constants.ExceptionMessage.EXCEPTION_ATTEMT_DIGIT;
import static racingcar.constants.ExceptionMessage.EXCEPTION_ATTEMT_RANGE;
import static racingcar.constants.ExceptionMessage.EXCEPTION_CARS_COUNT;
import static racingcar.constants.ExceptionMessage.EXCEPTION_NAME_LENGTH;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 전진_전진_동시우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("cindy,jessi", "1");
                    assertThat(output()).contains("cindy : -", "jessi : -", "최종 우승자 : cindy, jessi");
                },
                5, 4
        );
    }

    @Test
    void 정지_정지_동시우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("cindy,jessi", "1");
                    assertThat(output()).contains("cindy : ", "jessi : ", "최종 우승자 : cindy, jessi");
                },
                3, 3
        );
    }

    @Test
    void 자동차이름이_6자이상_일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessiJ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_NAME_LENGTH)
        );
    }

    @Test
    void 자동차이름이_0자일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,,jessi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_NAME_LENGTH)
        );
    }

    @Test
    void 자동차이름이_아무것도없을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_NAME_LENGTH)
        );
    }

    @Test
    void 참여하는_자동차가_1개_이하_일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_CARS_COUNT)
        );
    }

    @Test
    void 시도횟수가_문자일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_ATTEMT_DIGIT)
        );
    }

    @Test
    void 시도횟수가_0일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_ATTEMT_RANGE)
        );
    }

    @Test
    void 시도횟수가_0보다_작을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEPTION_ATTEMT_DIGIT)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

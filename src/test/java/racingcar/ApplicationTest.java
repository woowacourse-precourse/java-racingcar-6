package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 자동차이름이_6자이상_일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessiJ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름이_0자일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,,jessi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름이_아무것도없을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 참여하는_자동차가_1개_이하_일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가_문자일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가_0일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가_0보다_작을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cindy,jessi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

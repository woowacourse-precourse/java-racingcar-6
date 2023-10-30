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

    @Test
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리5() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("/n"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리6() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b,c,,d"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리7() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",a,b"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자에_대한_예외_처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자에_대한_예외_처리2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b", "01"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Test
    void 랜덤_변수_생성_테스트() {
        int result = Application.makeRandomNumber();
        assertThat(result).isBetween(0,9);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

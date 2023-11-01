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
    void 게임_끝까지_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,
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
    void 이름에_대한_예외_처리2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh,,hh","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh=", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리10() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리11() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리12() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123,5678", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh", "01"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자에_대한_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,dh", "abcd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

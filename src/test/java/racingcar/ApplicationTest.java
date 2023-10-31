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
                assertThatThrownBy(() -> runException("pobi,JunChangM", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void input이_없는_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @Test
    void input이_빈단어_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복우승자_경우(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,min", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "min : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 큰_값_시도의_경우(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "100");
                    assertThat(output()).contains("pobi : --------------------------------------------------" +
                            "--------------------------------------------------", "최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

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
    void 숫자_체크(){
        assertThatThrownBy(()-> run("aaa,bbb", "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_체크(){
        assertThatThrownBy(()-> run("aaa,bbb", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("int is minus");
    }

    @Test
    void 빈_문자열_길이(){
        assertThatThrownBy(()-> run("", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("carName length is not in 1~5");
        assertThatThrownBy(()-> run("aaaaaa,bbb", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("carName length is not in 1~5");
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

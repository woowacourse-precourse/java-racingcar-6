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
    void 이름에_대한_예외_처리() {

        //5글자 이상인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //영어가 아닌 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123,12", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_처리() {

        //음수
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //0으로 시작
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "01"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //0인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //영문
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "strasdf"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

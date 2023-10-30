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

    // Success
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

    // CarList Exception Test
    @Test
    void 이름에_대한_예외_처리1_6글자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리2_NoEnglish(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,안녕", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리3_NoName(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리4_DuplicatedName(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Amy,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // RacingNumber Class Exception Test
    @Test
    void 시도횟수에_대한_예외처리1_정수가아닌경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Amy,pobi", "y"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수에_대한_예외처리1_0일경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Amy,pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

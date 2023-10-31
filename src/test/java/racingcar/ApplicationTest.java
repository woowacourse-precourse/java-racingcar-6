package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

    public void setNumber(int num){
        if(num < 0){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    @Test
    void 시도할_횟수가_음수이면_예외처리(){
        int num = -3943;

        assertThatThrownBy(() -> setNumber(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 숫자가_아닌_경우_예외처리() {
        String input = "dfds";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자만 입력하세요"));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

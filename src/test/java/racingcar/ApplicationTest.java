package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    
    @Test @DisplayName("띄어쓰기로_이름_구분한_경우")
    void testCarName1() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("this That what", "3"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
        
    }
    
    @Test @DisplayName("차_아름이_5글자가_넘어가는_경우")
    void testCarName2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("thisIsName,isThatName", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
                
        );
    }
    

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

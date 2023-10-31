package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("전진, 정지에 따른 결과 확인")
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
    @DisplayName("이름에 대한 예외 처리")
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    @DisplayName("이름 존재 유무에 따른 Exception 발생")
    void getInputCarNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("RepeatNumber 예외 처리")
    void getRepeatNumber(){
        assertSimpleTest(()-> assertThatThrownBy(()->runException("pobi,woni","a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("RepeatNumber 음수 예외 처리")
    void getRepeatNumberMinus(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("pobi,woni","-1"))
                    .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

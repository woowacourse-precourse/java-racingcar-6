package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class RacingGameControllerTest extends NsTest {

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
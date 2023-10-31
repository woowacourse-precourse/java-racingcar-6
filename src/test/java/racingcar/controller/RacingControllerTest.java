package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingControllerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    @DisplayName("공동 우승자 테스트")
    void testTwoWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,blur", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "blur : -", "최종 우승자 : pobi, blur");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("이름 공백 포함 시 예외 발생 확인")
    void testExceptionCarNameHasSpace() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po bi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("count 값 숫자 아닐 경우 예외 발생 확인")
    void testExceptionCountIsNotInteger() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "ㅁㄴㅇ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
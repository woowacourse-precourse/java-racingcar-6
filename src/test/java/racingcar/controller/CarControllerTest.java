package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CarControllerTest extends NsTest {
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
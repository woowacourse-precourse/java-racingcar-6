package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

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
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("우승자가 3명일 경우 테스트")
    @Test
    void winnerListTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,won,suhw", "2");
                    assertThat(output()).contains("최종 우승자 : pobi, won, suhw");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("라운드 횟수에 대한 예외처리")
    @Test
    void gameRoundTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cat,dog", "1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자만 입력해주시길 바랍니다")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

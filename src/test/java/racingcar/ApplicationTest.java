package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("레이스에 대한 최종 우승자를 출력한다.")
    void testPrintGameWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("자동차 이름은 5글자를 넘어갈 수 없다.")
    void testCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("동점일 경우 공동 우승자를 모두 출력한다.")
    void testCoChampions() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");

                    assertThat(output()).contains("pobi : -", "woni : -");
                    assertThat(output()).containsAnyOf(
                            "최종 우승자 : pobi, woni",
                            "최종 우승자 : woni, pobi"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

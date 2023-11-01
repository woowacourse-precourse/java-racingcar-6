package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AllLogicTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("최종 우승자를 구한다.")
    void 최종_우승자를_구한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "1");
                    assertThat(output()).contains("a : -", "b : ", "c : ", "최종 우승자 : a");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("최종 우승자가 여러 명일 때 답을 구한다.")
    void 최종_우승자가_여러_명일_때_답을_구한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "1");
                    assertThat(output()).contains("a : ", "b : ", "c : ", "최종 우승자 : a, b, c");
                },
                STOP, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}


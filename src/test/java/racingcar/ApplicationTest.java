package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.zip.Deflater;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void 차_이름_구분_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jun", "1");
            assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi,woni");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이동횟수가_0보다_작거나_같음() {
        assertThrows(IllegalArgumentException.class, () -> {
            run("pobi,woni,jun", "0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

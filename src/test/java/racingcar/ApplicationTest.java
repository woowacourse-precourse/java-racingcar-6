package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.Utils;

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
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_공백_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,s sd", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "s"))
                        .isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 최고값_찾기() {
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        int result = Utils.getMaxValue(numberList);

        assertThat(result).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

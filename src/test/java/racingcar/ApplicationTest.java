package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void split_입력테스트1() {
        String input = ",,,,,";
        List<String> result = Arrays.asList(input.split(","));

        assertThat(result).isEmpty();
    }

    @Test
    void split_입력테스트2() {
        String input = "hwang,seong,heon,,,";
        List<String> result = Arrays.asList(input.split(","));

        assertThat(result.size()).isEqualTo(3);
        assertThat(result).containsExactly("hwang","seong","heon");
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수에_대한_예외_처리1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("hwang,seong,heon", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수에_대한_예외_처리2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("hwang,seong,heon", "2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

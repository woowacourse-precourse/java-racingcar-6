package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void validateCarInputBlank_유효성검사_성공_테스트() {
        String input = "red";

        Application.validateCarInputBlank(input);
    }

    @Test
    void validateCarInputBlank_유효성검사_실패_테스트() {
        String input = "";

        assertThatThrownBy(() -> Application.validateCarInputBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputBlank_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputBlank(inputList);
    }

    @Test
    void validateCarListInputBlank_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("", "red", "green");

        assertThatThrownBy(() -> Application.validateCarListInputBlank(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

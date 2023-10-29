package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.Validation;

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
    void 이름_입력안한_경우_처리() {
        List<String> input = new ArrayList<>();

        assertThatThrownBy(() -> Validation.validateEmtpy(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_예외_처리() {
        List<String> input = List.of("abc", "cde", "abcdef");

        assertThatThrownBy(() -> Validation.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복_예외_처리() {
        List<String> input = List.of("Abc", "abc");

        assertThatThrownBy(() -> Validation.validateDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_알파벳_이외_문자_예외_처리() {
        List<String> input = List.of("abd", "qAz", "aq1");

        assertThatThrownBy(() -> Validation.validateCharacters(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_예외_처리() {
        String input = "1 ";

        assertThatThrownBy(() -> Validation.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    public static class ValidatorTest {
        private final Validator validator = new Validator();
        private static final String ERROR_MESSAGE = "[ERROR]";

        @Test
        void 자동차이름_빈문자_입력() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkCarNamesInput(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }

        @Test
        void 시도횟수이름_빈문자_입력() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkNumberOfTrialInput(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }

        @Test
        void 자동차이름_1글자미만() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkCarNamesInput("a,"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,,c"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }

        @Test
        void 자동차이름_5글자초과() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,avsdfe"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }

        @Test
        void 자동차이름_공백() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkCarNamesInput("a, ,c"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }

        @Test
        void 자동차이름_중복() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkCarNamesInput("a,a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }

        @Test
        void 시도횟수_문자() {
            assertSimpleTest(() -> AssertionsForClassTypes.assertThatThrownBy(() -> validator.checkNumberOfTrialInput("a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE));
        }
    }
}

package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ViewerTest {
    private final Viewer viewer = new Viewer();

    @Nested
    class 자동차_이름_입력 extends NsTest {
        @Test
        void 입력이_이름과_쉼표로만_이루어지지_않은_경우_예외() {
            final String input = "pobi.woni";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력은 자동차 이름과 구분자(,)만 가능합니다."));
        }

        @Override
        protected void runMain() {
            viewer.inputCarNames();
        }
    }

    @Nested
    class 시도_회수_입력 extends NsTest {
        @Test
        void 시도_횟수가_숫자가_아닌_경우_예외() {
            final String input = "a";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("시도 횟수는 숫자여야 합니다."));
        }

        @Override
        protected void runMain() {
            viewer.inputTryCount();
        }
    }
}

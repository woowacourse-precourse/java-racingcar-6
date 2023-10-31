package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    private final InputView inputView = new InputView();

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

        @Test
        void 이름에_공백이_있을_경우_예외() {
            final String input = "pob  i,woni";
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름에는 공백이 포함될 수 없습니다.");
            });
        }

        @Test
        void 입력에_공백을_제거하여_이름_목록을_생성하는지() {
            final String input = " pobi,    woni ";
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("pobi", "woni");
            });
        }

        @Override
        protected void runMain() {
            List<String> carNames = inputView.inputCarNames();
            System.out.println(carNames);
        }
    }

    @Nested
    class 시도_횟수_입력 extends NsTest {
        @Test
        void 시도_횟수가_숫자가_아닌_경우_예외() {
            final String input = "a";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("시도 횟수는 숫자여야 합니다."));
        }

        @ParameterizedTest(name = "실패_시도_횟수가_{0}인_경우")
        @ValueSource(strings = {"0", "-1"})
        void 시도_횟수가_0보다_적거나_음수인_경우_예외(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("시도 횟수는 1 이상이어야 합니다."));
        }

        @Override
        protected void runMain() {
            inputView.inputTryCount();
        }
    }
}

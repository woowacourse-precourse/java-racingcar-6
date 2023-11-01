package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("input view 에서 ")
class InputViewTest {

    private InputView inputView = new InputView();

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();
    }

    @Nested
    @DisplayName("readCarNames 메서드는 ")
    class ReadCarNamesTest {
        @Test
        void 사용자가_입력한_문자열을_리스트로_변환한다() {
            String input = "a,b";
            setInput(input);

            List<String> output = inputView.readCarNames()
                    .stream()
                    .map(Car::getName)
                    .toList();

            assertThat(output).isEqualTo(List.of(input.split(",")));
        }

        @Test
        void 공백만_입력하면_예외가_발생한다() {
            String input = "\n";
            setInput(input);

            assertThatThrownBy(inputView::readCarNames)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차이름에_공백을_입력하면_예외가_발생한다() {
            String input = "a,,,b";
            setInput(input);

            assertThatThrownBy(inputView::readCarNames)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 이름에_공백을_입력하면_공백은_무시한다() {
            setInput("a,         b");
            String input = "a,b";

            List<String> output = inputView.readCarNames()
                    .stream()
                    .map(Car::getName)
                    .toList();

            assertThat(output).isEqualTo(List.of(input.split(",")));
        }

        @Test
        void 여섯글자_이상_입력하면_예외가_발생한다() {
            String input = "aaaaaa,b";
            setInput(input);

            assertThatThrownBy(inputView::readCarNames)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("readRoundCountTest")
    class ReadRoundCountTest {

        @Test
        void 숫자가_아닌_문자를_입력하면_예외가_발생한다() {
            String input = "a";
            setInput(input);

            assertThatThrownBy(inputView::readRoundCount)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자를_입력하면_성공한다() {
            String input = "5";
            setInput(input);

            int output = inputView.readRoundCount();

            assertThat(input).isEqualTo(String.valueOf(output));
        }
    }
}
package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.printer.MockPrinter;
import racingcar.view.reader.MockReader;

class InputViewTest {

    @Nested
    @DisplayName("경주 할 자동차 이름 입력 기능 테스트")
    class InputNamesTest {

        private static final String EXAMPLE_NAMES = "pobi,woni,jun";

        @Test
        @DisplayName("이름 입력 요청 메세지를 출력한다")
        void inputNamesTest_printRequestMessage() {
            MockPrinter printer = new MockPrinter();
            InputView inputView = new InputView(new MockReader(EXAMPLE_NAMES), printer);
            String expectedMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)%n".formatted();

            inputView.inputNames();

            String printedMessage = printer.getPrintedMessage();
            assertThat(printedMessage).isEqualTo(expectedMessage);
        }

        @ParameterizedTest(name = "입력 값 : [{0}]")
        @CsvSource({"''", "' '", "'\n\t'"})
        @DisplayName("입력 받은 값이 빈칸이라면 예외를 발생시킨다")
        void inputNamesTest_whenInputBlank_throwException(String inputMessage) {
            InputView inputView = new InputView(new MockReader(inputMessage), new MockPrinter());

            assertThatThrownBy(inputView::inputNames)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("적어도 하나의 문자를 입력해야 합니다");
        }

        @Test
        @DisplayName("입력 받은 이름을 형식에 맞춰 분리할 수 있다")
        void inputNamesTest_separateNames() {
            String inputMessage = "pobi,steve,jun,end";
            InputView inputView = new InputView(new MockReader(inputMessage), new MockPrinter());
            List<String> expect = List.of("pobi", "steve", "jun", "end");

            List<String> actual = inputView.inputNames();

            assertThat(expect).isEqualTo(actual);
        }
    }

    @Nested
    @DisplayName("시도할 횟수 입력 기능 테스트")
    class InputCountOfTryTest {

        private static final String EXAMPLE_COUNT_OF_TRY = "5";

        @Test
        @DisplayName("시도 횟수 입력 요청 메세지를 출력한다")
        void inputNamesTest_printRequestMessage() {
            MockPrinter printer = new MockPrinter();
            InputView inputView = new InputView(new MockReader(EXAMPLE_COUNT_OF_TRY), printer);
            String expectedMessage = "시도할 회수는 몇회인가요?%n".formatted();

            inputView.inputCountOfTry();

            String printedMessage = printer.getPrintedMessage();
            assertThat(printedMessage).isEqualTo(expectedMessage);
        }

        @ParameterizedTest(name = "입력 값 : [{0}]")
        @CsvSource({"' '", "3a", "steve", "&", "2147483648"})
        @DisplayName("입력 받은 값이 숫자가 아니거나 형식과 맞지 않으면 예외를 발생시킨다")
        void inputNamesTest_whenFormatIsNotMatched_throwException(String inputMessage) {
            InputView inputView = new InputView(new MockReader(inputMessage), new MockPrinter());

            assertThatThrownBy(inputView::inputCountOfTry)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("int 형식의 숫자를 입력해야 합니다");
        }

        @ParameterizedTest(name = "입력 값 : [{0}]")
        @CsvSource({"'3',3", "'+10 ',10", "' 70 ',70"})
        @DisplayName("입력 받은 횟수를 반환할 수 있다")
        void inputNamesTest(String inputMessage, int expected) {
            InputView inputView = new InputView(new MockReader(inputMessage), new MockPrinter());

            int actual = inputView.inputCountOfTry();

            assertThat(actual).isEqualTo(expected);
        }
    }
}

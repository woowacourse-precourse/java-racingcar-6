package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.util.ConsoleInputUtil;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InputViewTest {

    @DisplayName("사용자로부터 경주에 참여할 자동차 이름 목록을 문자열로 입력받아서, 문자열 리스트로 반환한다.")
    @MethodSource("carNamesProvider")
    @ParameterizedTest(name = "[{index}] \"{0}\" => {1}")
    void Given_InputView_When_InputCarNames_Then_ReturnCarNameList(String userInput, List<String> expected) throws Exception {
        // Given
        ConsoleInputUtil consoleInputUtil = setTestConsoleInputUtil(userInput);
        InputView inputView = new InputView(consoleInputUtil);

        // When
        List<String> carNames = inputView.inputCarNames();

        // Then
        assertThat(carNames).isEqualTo(expected);
    }

    private ConsoleInputUtil setTestConsoleInputUtil(String input) {
        return new ConsoleInputUtil() {
            @Override
            public String input() {
                return input;
            }
        };
    }

    private static Stream<Arguments> carNamesProvider() {
        return Stream.of(
                arguments("edgar", List.of("edgar")),
                arguments("a,b,c,d,e", List.of("a", "b", "c", "d", "e")),
                arguments("edgar,kue", List.of("edgar", "kue"))
        );
    }

    @DisplayName("사용자에게 경주 진행 횟수를 입력받아 반환한다.")
    @Test
    void Given_InputView_When_InputRaceCount_Then_ReturnRaceCount() throws Exception {
        // Given
        String userInput = "5";
        int expectedRaceCount = 5;
        ConsoleInputUtil consoleInputUtil = setTestConsoleInputUtil(userInput);
        InputView inputView = new InputView(consoleInputUtil);

        // When
        int inputRaceCount = inputView.inputRaceCount();

        // Then
        assertThat(inputRaceCount).isEqualTo(expectedRaceCount);
    }

    @DisplayName("경주 진행 횟수로 정수가 아닌 값이 입력되면, 예외가 발생한다.")
    @Test
    void Given_InputView_When_InputInvalidValue_Then_ThrowException() throws Exception {
        // Given
        String userInput = "NOT_NUMBER_TYPE_VALUE";
        ConsoleInputUtil consoleInputUtil = setTestConsoleInputUtil(userInput);
        InputView inputView = new InputView(consoleInputUtil);

        // When & Then
        assertThatThrownBy(() -> inputView.inputRaceCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 진행 횟수는 정수만 입력할 수 있습니다.");
    }
}

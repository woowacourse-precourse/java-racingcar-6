package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.exception.ExceptionMessages;

public class ConsoleInputViewTest {

    private ConsoleInputView consoleInputView;

    @BeforeEach
    protected final void initializeConsoleInputView() {
        consoleInputView = new ConsoleInputView();
    }

    @Test
    void 경주할_자동차_이름을_입력() {
        final String expected = "pobi,woni,jun";

        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(expected);
            final String actual = consoleInputView.readCarNames();
            assertThat(actual).contains(expected);
        }
    }

    @Test
    @DisplayName("사용자에게 입력을 받아 몇 번 이동할 지 데이터로 저장한다.")
    void 시도할_회수를_입력() {
        final int expected = 5;

        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(String.valueOf(expected));
            final int actual = consoleInputView.readTryCount();
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("주어진 횟수를 입력할 때 숫자가 아닌 입력 시 예외를 일으킨다.")
    void 시도할_회수를_입력시_숫자가_아닌경우_예외() {
        final String expected = "가";

        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(expected);
            assertThatThrownBy(() -> consoleInputView.readTryCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessages.INPUT_ONLY_NUMBERS.getMessage());
        }
    }
}

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import racingcar.util.ConsoleWrapper;
import racingcar.view.ConsoleView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleViewTest {
    private final ConsoleWrapper consoleWrapper = Mockito.mock(ConsoleWrapper.class);
    private final ConsoleView consoleView = new ConsoleView(consoleWrapper);


    @Test
    @DisplayName("유효한 시도 횟수 입력 시 정상 동작")
    void validateValidNumberOfAttempts() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("3");

        // when
        int numberOfAttempts = consoleView.readValidNumberOfAttempts();

        // then
        assertThat(numberOfAttempts).isEqualTo(3);
    }

    @Test
    @DisplayName("유효하지 않은 시도 횟수 입력 시 예외 발생")
    void validateInvalidNumberOfAttempts() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("0");

        // when, then
        assertThatThrownBy(() -> consoleView.readValidNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 회수가 아닙니다.");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void validateEmptyInput() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("");

        // when, then
        assertThatThrownBy(() -> consoleView.readValidNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 회수가 아닙니다.");
    }

    @Test
    @DisplayName("음수 입력 시 예외 발생")
    void validateNegativeInput() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("-1");

        // when, then
        assertThatThrownBy(() -> consoleView.readValidNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 회수가 아닙니다.");
    }

    @Test
    @DisplayName("소수 입력 시 예외 발생")
    void validateFloatingPointInput() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("1.5");

        // when, then
        assertThatThrownBy(() -> consoleView.readValidNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 회수가 아닙니다.");
    }

    @Test
    @DisplayName("문자열 입력 시 예외 발생")
    void validateStringInput() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("abc");

        // when, then
        assertThatThrownBy(() -> consoleView.readValidNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 회수가 아닙니다.");
    }

    @Test
    @DisplayName("유효하지 않은 회수 입력 시 예외 발생: 특수문자 포함")
    void validateInvalidInputWithSpecialCharacters() {
        // given
        Mockito.when(consoleWrapper.readLine()).thenReturn("3#");

        // when, then
        assertThatThrownBy(() -> consoleView.readValidNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 회수가 아닙니다.");
    }
}
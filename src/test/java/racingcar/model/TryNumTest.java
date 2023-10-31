package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import camp.nextstep.edu.missionutils.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TryNumTest {

    @BeforeEach
    void 초기화() {
        // 초기화 로직 (필요하다면)
    }

    @Test
    void 유효한_문자열을_정수로_변환() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("5");
            int result = InputView.numberInput();
            assertEquals(5, result);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "a12", "12a", ""})
    void 유효하지않은_문자열_예외처리_테스트(String input) {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn(input);
            assertThrows(IllegalArgumentException.class, InputView::numberInput);
        }
    }

    @Test
    void 입력값이_1보다_작을때_예외처리_테스트() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("0");
            assertThrows(IllegalArgumentException.class, InputView::numberInput);
        }
    }
}

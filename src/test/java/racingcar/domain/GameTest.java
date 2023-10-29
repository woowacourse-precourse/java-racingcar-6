package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void init() {
    }

    @Test
    void run() {
    }

    @Test
    void finish() {
    }

    @Test
    void inputCarNames() {
        String input = "pobi,woni,jun";
        String[] output = {"pobi", "woni", "jun"};

        try (MockedStatic<Console> mockedStatic = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(input);
            assertThat(game.inputCarNames()).isEqualTo(output);
            mockedStatic.verify(Console::readLine, times(1));
        }
    }

    @Test
    void inputCarNames_Exception_EmptyName() {
        String input = "pobi,,jun";

        try (MockedStatic<Console> mockedStatic = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(input);
            assertThatThrownBy(() -> game.inputCarNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Not valid input: car names");
            mockedStatic.verify(Console::readLine, times(1));
        }
    }

    @Test
    void inputCardNames_Exception_MoreThanFiveCharacters() {
        String input = "pobi,woni,jun,dongjin";

        try (MockedStatic<Console> mockedStatic = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(input);
            assertThatThrownBy(() -> game.inputCarNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Not valid input: car names");
            mockedStatic.verify(Console::readLine, times(1));
        }
    }

    @Test
    void inputGameTurns() {
        String input = "10";

        try(MockedStatic<Console> mockedStatic = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(input);
            assertThatCode(() -> game.inputGameTurns()).doesNotThrowAnyException();
            mockedStatic.verify(Console::readLine, times(1));
        }
    }

    @Test
    void inputGameTurns_Exception_NotNumber() {
        String input = "...";

        try(MockedStatic<Console> mockedStatic = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(input);
            assertThatThrownBy(() -> game.inputGameTurns())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Not valid input: game turn number");
            mockedStatic.verify(Console::readLine, times(1));
        }
    }

    @Test
    void inputGameTurns_Exception_NegativeNumber() {
    }

    @Test
    void findWinners() {
    }

    @Test
    void winnersToString() {
    }
}
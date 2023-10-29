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
        String input = "-1";

        try (MockedStatic<Console> mockedStatic = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(input);
            assertThatThrownBy(() -> game.inputGameTurns())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Not valid input: game turn number");
            mockedStatic.verify(Console::readLine, times(1));
        }
    }

    @Test
    void findWinners() {
        String carNames = "pobi,woni,jun";
        String gameTurns = "5";

        final int GO = 4;
        final int STOP = 3;
        Integer[] randoms = {STOP, GO, GO, STOP, GO, GO, GO, GO, GO, GO, GO, GO, GO, GO};

        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class);
             MockedStatic<RandomMaker> randomMakerMockedStatic = mockStatic(RandomMaker.class)) {
            when(Console.readLine()).thenReturn(carNames, gameTurns);
            when(RandomMaker.makeRandomNumber()).thenReturn(GO, randoms);

            assertThatCode(() -> {
                game.init();
                game.run();
                game.findWinners();
            }).doesNotThrowAnyException();

            consoleMockedStatic.verify(Console::readLine, times(2));
            randomMakerMockedStatic.verify(RandomMaker::makeRandomNumber, times(15));
        }
    }

    @Test
    void winnersToString() {
        String carNames = "pobi,woni";
        String gameTurns = "1";

        final int GO = 4;
        final int STOP = 3;

        String expected = "최종 우승자 : pobi";

        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class);
             MockedStatic<RandomMaker> randomMakerMockedStatic = mockStatic(RandomMaker.class)) {
            when(Console.readLine()).thenReturn(carNames, gameTurns);
            when(RandomMaker.makeRandomNumber()).thenReturn(GO, STOP);

            game.init();
            game.run();
            game.findWinners();
            assertThat(game.winnersToString()).isEqualTo(expected);

            consoleMockedStatic.verify(Console::readLine, times(2));
            randomMakerMockedStatic.verify(RandomMaker::makeRandomNumber, times(2));
        }
    }
}
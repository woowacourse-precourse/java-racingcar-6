package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.*;

class GameTest {
    Game game;
    MockedStatic<Console> consoleMockedStatic;
    MockedStatic<RandomMaker> randomMakerMockedStatic;

    @BeforeEach
    void setUp() {
        game = new Game();
        consoleMockedStatic = mockStatic(Console.class);
        randomMakerMockedStatic = mockStatic(RandomMaker.class);
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

        when(Console.readLine()).thenReturn(input);
        assertThat(game.inputCarNames()).isEqualTo(output);
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputCarNames_Exception_EmptyName() {
        String input = "pobi,,jun";

        when(Console.readLine()).thenReturn(input);
        assertThatThrownBy(() -> game.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: car names");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputCardNames_Exception_MoreThanFiveCharacters() {
        String input = "pobi,woni,jun,dongjin";

        when(Console.readLine()).thenReturn(input);
        assertThatThrownBy(() -> game.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: car names");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputGameTurns() {
        String input = "10";

        when(Console.readLine()).thenReturn(input);
        assertThatCode(() -> game.inputGameTurns()).doesNotThrowAnyException();
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputGameTurns_Exception_NotNumber() {
        String input = "...";

        when(Console.readLine()).thenReturn(input);
        assertThatThrownBy(() -> game.inputGameTurns())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: game turn number");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputGameTurns_Exception_NegativeNumber() {
        String input = "-1";

        when(Console.readLine()).thenReturn(input);
        assertThatThrownBy(() -> game.inputGameTurns())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: game turn number");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void findWinners() {
        String carNames = "pobi,woni,jun";
        String gameTurns = "5";

        final int GO = 4;
        final int STOP = 3;
        Integer[] randoms = {STOP, GO, GO, STOP, GO, GO, GO, GO, GO, GO, GO, GO, GO, GO};

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

    @Test
    void winnersToString() {
        String carNames = "pobi,woni";
        String gameTurns = "1";

        final int GO = 4;
        final int STOP = 3;

        String expected = "최종 우승자 : pobi";

        when(Console.readLine()).thenReturn(carNames, gameTurns);
        when(RandomMaker.makeRandomNumber()).thenReturn(GO, STOP);

        game.init();
        game.run();
        game.findWinners();
        assertThat(game.winnersToString()).isEqualTo(expected);

        consoleMockedStatic.verify(Console::readLine, times(2));
        randomMakerMockedStatic.verify(RandomMaker::makeRandomNumber, times(2));
    }

    @AfterEach
    void tearDown() {
        consoleMockedStatic.close();
        randomMakerMockedStatic.close();
    }
}
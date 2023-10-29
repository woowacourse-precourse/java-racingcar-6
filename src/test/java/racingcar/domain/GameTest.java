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
    private static final int GO = 4, STOP = 3;
    private Game game;
    private MockedStatic<Console> consoleMockedStatic;
    private MockedStatic<RandomMaker> randomMakerMockedStatic;
    private String carNamesInput, gameTurnsInput;
    private Integer[] randomArray;

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
        carNamesInput = "pobi,woni,jun";
        String[] expected = {"pobi", "woni", "jun"};

        when(Console.readLine()).thenReturn(carNamesInput);
        assertThat(game.inputCarNames()).isEqualTo(expected);
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputCarNames_Exception_EmptyName() {
        carNamesInput = "pobi,,jun";

        when(Console.readLine()).thenReturn(carNamesInput);
        assertThatThrownBy(() -> game.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: car names");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputCardNames_Exception_MoreThanFiveCharacters() {
        carNamesInput = "pobi,woni,jun,dongjin";

        when(Console.readLine()).thenReturn(carNamesInput);
        assertThatThrownBy(() -> game.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: car names");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputGameTurns() {
        gameTurnsInput = "10";

        when(Console.readLine()).thenReturn(gameTurnsInput);
        assertThatCode(() -> game.inputGameTurns()).doesNotThrowAnyException();
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputGameTurns_Exception_NotNumber() {
        gameTurnsInput = "...";

        when(Console.readLine()).thenReturn(gameTurnsInput);
        assertThatThrownBy(() -> game.inputGameTurns())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: game turn number");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void inputGameTurns_Exception_NegativeNumber() {
        gameTurnsInput = "-1";

        when(Console.readLine()).thenReturn(gameTurnsInput);
        assertThatThrownBy(() -> game.inputGameTurns())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not valid input: game turn number");
        consoleMockedStatic.verify(Console::readLine, times(1));
    }

    @Test
    void findWinners() {
        carNamesInput = "pobi,woni,jun";
        gameTurnsInput = "5";

        randomArray = new Integer[] {STOP, GO, GO, STOP, GO, GO, GO, GO, GO, GO, GO, GO, GO, GO};

        when(Console.readLine()).thenReturn(carNamesInput, gameTurnsInput);
        when(RandomMaker.makeRandomNumber()).thenReturn(GO, randomArray);

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
        carNamesInput = "pobi,woni";
        gameTurnsInput = "1";

        String expected = "최종 우승자 : pobi";

        when(Console.readLine()).thenReturn(carNamesInput, gameTurnsInput);
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
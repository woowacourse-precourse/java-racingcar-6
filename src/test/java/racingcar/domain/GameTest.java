package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
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
        }
    }

    @Test
    void inputCarNames_Exception_EmptyName() {
    }

    @Test
    void inputCardNames_Exception_MoreThanFiveCharacters() {

    }

    @Test
    void inputGameTurns() {
    }

    @Test
    void inputGameTurns_ThrownByIllegalArgumentException() {
    }

    @Test
    void findWinners() {
    }

    @Test
    void winnersToString() {
    }
}
package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.configurator.GameSetter;

import static org.mockito.Mockito.*;

public class GameControllerTest {

    private GameController gameController;
    private GameSetter gameSetter;
    private GameRule gameRule;

    @BeforeEach
    public void setUp() {
        gameSetter = mock(GameSetter.class);
        gameRule = mock(GameRule.class);

        when(gameSetter.getCoin()).thenReturn(5);

        gameController = new GameController(gameSetter, gameRule);
    }

    @Test
    public void testRun() {
        gameController.run();

        verify(gameSetter).registerCars();
        verify(gameRule, times(5)).playRound();
        verify(gameRule).calculateWinner();
    }

    @Test
    public void testPlayGame() {
        gameController.playGame();

        verify(gameRule, times(5)).playRound();
        verify(gameRule).calculateWinner();
    }

    @Test
    public void testPrintWinner() {
        gameController.printWinner();

        verify(gameRule).calculateWinner();
    }
}

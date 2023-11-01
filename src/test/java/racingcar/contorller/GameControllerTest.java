package racingcar.contorller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Game;
import racingcar.model.GameFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControllerTest {
    private GameController gameController;
    private Game mockGame;

    @BeforeEach
    public void setup() throws Exception {
        OutputView mockOutputView = mock(OutputView.class);
        InputView mockInputView = mock(InputView.class);

        // Creating mockGame
        mockGame = mock(Game.class);
        when(mockGame.hasRemainingRounds()).thenReturn(true, true, true, false);
        when(mockGame.getCars()).thenReturn(Collections.emptyList());

        // Creating mockFactory
        GameFactory mockFactory = mock(GameFactory.class);
        when(mockFactory.createGame(any(), anyInt())).thenReturn(mockGame);

        // Using reflection to set the mockGame in the gameController
        gameController = new GameController(mockInputView, mockOutputView, mockFactory);
        Field gameField = GameController.class.getDeclaredField("game");
        gameField.setAccessible(true);
        gameField.set(gameController, mockGame);

        // Mock the user inputs
        when(mockInputView.inputCarNames()).thenReturn("car1,car2");
        when(mockInputView.inputNumberOfAttempts()).thenReturn("3");
    }

    @Test
    @DisplayName("시도 회수 3만큼 라운드를 3번 진행한다")
    public void test_shouldCallPlayOneRoundThreeTimes() {
        gameController.run();

        verify(mockGame, times(3)).playOneRound();
    }
}

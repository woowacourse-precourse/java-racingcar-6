package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.view.ConsoleView;

import static org.mockito.Mockito.*;

public class GameControllerTest {
    @Test
    public void 정상적으로_시작_종료() {
        ConsoleView view = mock(ConsoleView.class);
        when(view.readCarNames()).thenReturn("car1,car2");
        when(view.readMovement()).thenReturn(5);

        GameController controller = new GameController(view);
        controller.startGame();

        verify(view, times(1)).printWinners(anyList());
    }
}
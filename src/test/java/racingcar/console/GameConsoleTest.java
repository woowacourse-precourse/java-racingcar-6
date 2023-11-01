package racingcar.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import racingcar.console.game.GameList;
import racingcar.console.game.racingcar.RacingCarGame;

class GameConsoleTest {

    private GameConsole gameConsole;

    @Mock
    private RacingCarGame racingCarGame;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Mock 객체 초기화
        gameConsole = new GameConsole(racingCarGame);
    }


    @Test
    public void testStartWithRacingCarGame() {
        // Arrange: Create a Mock RacingCarGame

        // Act: Start the game
        gameConsole.start();

        // Assert: Verify that the RacingCarGame's start method is called
        Mockito.verify(racingCarGame).start();
    }

}
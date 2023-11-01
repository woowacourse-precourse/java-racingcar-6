package Service;

import Domain.Game;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {

    @Test
    public void createGame_ShouldCreateGameWithCarsAndTryCount() {
        // Arrange
        GameService gameService = new GameService();

        // Act
        Game game = gameService.testCreateGame();
        gameService.testGetCarName();
        gameService.testGetTryCount();

        // Assert
        assertThat(game.getCars()).isNotNull(); // Check if cars are not null
        assertThat(game.getTryCount()).isGreaterThan(0); // Check if tryCount is greater than 0
    }
}

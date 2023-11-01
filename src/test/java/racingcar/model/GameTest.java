package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[GameTest]")
public class GameTest {
    @Test
    @DisplayName("")
    void isGameEndTest_False() {
        // Given
        Game game = new Game("4");

        // When
        boolean isGameEnd = game.isGameEnd();

        // Then
        assertThat(isGameEnd).isFalse();
        assertThat(game.getTryCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("")
    void isGameEndTest_True() {
        // Given
        Game game = new Game("1");

        // When
        game.isGameEnd();
        boolean isGameEnd = game.isGameEnd();

        // Then
        assertThat(isGameEnd).isTrue();
        assertThat(game.getTryCount()).isEqualTo(0);
    }
}

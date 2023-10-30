package study;

import org.junit.jupiter.api.Test;
import racingcar.domain.ErrorMessage;
import racingcar.domain.GameManager;
import study.mock.MockGameConsole;
import study.mock.MockNumberGenerator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameManagerTest {

    @Test
    void 경주_자동차를_한대만_입력한_경우_예외발생() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream("pobi");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When & Then
        assertThatThrownBy(gameManager::readCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MINIMUM_CAR_COUNT.getMessage());
    }

    @Test
    void 경주_자동차_이름이_비어있는_경우_예외발생() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream(",pobi");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When & Then
        assertThatThrownBy(gameManager::readCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_IS_BLANK.getMessage());
    }

    @Test
    void 경주_자동차_이름이_다섯_글자를_넘는_경우_예외발생() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream("pobi,hunsope");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When & Then
        assertThatThrownBy(gameManager::readCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEEDED_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    void 경주_자동차_이름을_정상적으로_입력한_경우_정상실행() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream("pobi,woni,jun");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When
        gameManager.readCarNames();
    }
}

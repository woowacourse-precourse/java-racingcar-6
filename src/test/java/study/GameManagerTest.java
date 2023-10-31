package study;

import org.junit.jupiter.api.Test;
import racingcar.domain.ErrorMessage;
import racingcar.domain.GameManager;
import study.mock.MockGameConsole;
import study.mock.MockNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 입력한_시도_횟수가_숫자가_아닌_경우_예외발생() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream("english");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When & Then
        assertThatThrownBy(gameManager::readAttemptCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ATTEMPT_COUNT_IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 입력한_시도_횟수가_0인_경우_예외발생() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream("0");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When & Then
        assertThatThrownBy(gameManager::readAttemptCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MINIMUM_ATTEMPT_COUNT.getMessage());
    }

    @Test
    void 시도_횟수를_정상적으로_입력한_경우_정상실행() {
        // Given
        MockGameConsole gameConsole = new MockGameConsole();
        gameConsole.setMockStream("3");
        GameManager gameManager = new GameManager(new MockNumberGenerator(), gameConsole);

        // When
        gameManager.readAttemptCount();
    }

    @Test
    void 게임이_정상적인_흐름으로_실행되는지_테스트() {
        // Given
        MockNumberGenerator numberGenerator = new MockNumberGenerator();
        MockGameConsole gameConsole = new MockGameConsole();
        GameManager gameManager = new GameManager(numberGenerator, gameConsole);

        numberGenerator.setRandomNumbers(List.of(1, 2, 4, 1, 2, 5));
        gameConsole.setMockStream("pobi,woni,jun", "2");

        // When
        gameManager.readCarNames();
        gameManager.readAttemptCount();
        gameManager.startGame();

        // Then
        String gameWinner = gameManager.getGameWinner();
        assertThat(gameWinner).isEqualTo("jun");
    }
}

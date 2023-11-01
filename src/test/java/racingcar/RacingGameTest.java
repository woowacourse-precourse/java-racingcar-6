package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    @DisplayName("자동차 이름이 5를 초과했을 때 에러 발생하는지 확인")
    @Test
    public void testIsCarNameValidThrowsExceptionForLongCarName() {
        RacingGame racingGame = new RacingGame();
        String[] carNames = {"Car1", "Car22", "Car333", "Car4444", "Car55555"};

        assertThrows(IllegalArgumentException.class, () -> racingGame.isCarNameValid(carNames));
    }

    @DisplayName("자동차 이름이이 5 이하일 때 에러가 발생하지 않는 것을 확인")
    @Test
    public void testIsCarNameValidDoesNotThrowExceptionForValidCarName() {
        RacingGame racingGame = new RacingGame();
        String[] carNames = {"Car1", "Car2", "Car3", "Car44", "Car55"};

        assertDoesNotThrow(() -> racingGame.isCarNameValid(carNames));
    }
}

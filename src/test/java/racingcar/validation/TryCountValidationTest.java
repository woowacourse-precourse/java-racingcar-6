package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputManager;

public class TryCountValidationTest {
    InputManager inputManager;

    @BeforeEach
    public void beforeEach() {
        inputManager = new InputManager();
    }

    @Test
    void isValidateTryCount_성공() {
        //given
        String input = "5";
        //when/then
        assertDoesNotThrow(() -> {
            inputManager.isValidateTryCount(input);
        });
    }

    @Test
    void isValidateTryCount_실패_숫자가_아닌_경우() {
        //given
        String input = "a";
        //when
        assertThatThrownBy(() -> inputManager.isValidateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID tryCount : non-numeric characters");
    }

    @Test
    void isValidateTryCount_실패_1보다_작은_경우() {
        //given
        String input = "0";
        //when
        assertThatThrownBy(() -> inputManager.isValidateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID tryCount : number less than 1");
    }
}

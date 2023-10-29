package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RacingGameManagerTest {

    @Test
    void 시도할_횟수가_1보다_작다면_예외발생() {
        //Given
        String inputNegativeNumber = "-1";
        String inputZero = "0";
        RacingGameManager racingGameManager = new RacingGameManager();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> racingGameManager.tryCountValidation(inputNegativeNumber));
        assertThrows(IllegalArgumentException.class, () -> racingGameManager.tryCountValidation(inputZero));
    }

    @Test
    void 시도할_횟수가_숫자가_아니라면_예외발생() {
        //Given
        String inputValue = "sd";
        RacingGameManager racingGameManager = new RacingGameManager();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> racingGameManager.tryCountValidation(inputValue));
    }
}

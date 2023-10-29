package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.model.Cars;

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

    @Test
    void 시도_횟수_만큼_자동차_이동_함수_호출(){
        // Given
        int tryCount = 3;
        Cars spyCars = Mockito.spy(new Cars());
        RacingGameManager racingGameManager = new RacingGameManager(spyCars);

        // When
        racingGameManager.repeatMove(tryCount);

        // Then
        Mockito.verify(spyCars, times(tryCount)).moveCars();
    }
}

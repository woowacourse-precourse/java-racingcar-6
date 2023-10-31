package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.Cars;

public class RacingGameManagerTest {

    @DisplayName("시도 횟수가 1보다 작거나 숫자가 아닌 경우 예외 발생")
    @Test
    void tryCountIsNegativeOrZero() {
        assertTryCount("-1");
        assertTryCount("0");
    }

    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생")
    @Test
    void tryCountIsNotInteger() {
        assertTryCount("not integer");
    }

    @DisplayName("시도 횟수만큼 전진 메서드 호출")
    @Test
    void callMoveMethodByTryCount(){
        // Given
        int tryCount = 3;
        Cars spyCars = Mockito.spy(new Cars());
        RacingGameManager racingGameManager = new RacingGameManager(spyCars, new InputView(), new OutputView());

        // When
        racingGameManager.repeatRun(tryCount);

        // Then
        Mockito.verify(spyCars, times(tryCount)).runCars();
    }

    private void assertTryCount(String inputTryCount){
        //Given
        RacingGameManager racingGameManager = new RacingGameManager();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> racingGameManager.tryCountValidation(inputTryCount));
    }
}

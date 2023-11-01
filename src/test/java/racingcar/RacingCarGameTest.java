package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGame;
import racingcar.model.RacingResult;
import racingcar.view.RacingGameException;
import racingcar.view.UserInput;

public class RacingCarGameTest {

    @Test
    void testRun() {
        UserInput userInput = mock(UserInput.class);
        when(userInput.readCarNames()).thenReturn(new String[]{"car1", "car2", "car3"});
        when(userInput.readNumberOfAttempts()).thenReturn(5);

        RacingCarGame racingCarGame = new RacingCarGame(userInput);
        RacingResult result = racingCarGame.run();
        assertThat(result).isNotNull();
    }

    @Test
    void testRunWithException() {
        UserInput userInput = mock(UserInput.class);
        when(userInput.readCarNames()).thenThrow(new RacingGameException("테스트 예외"));

        RacingCarGame racingCarGame = new RacingCarGame(userInput);
        RacingResult result = racingCarGame.run();
        assertThat(result).isNull();
    }

}



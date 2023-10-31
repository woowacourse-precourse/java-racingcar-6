package racingcar.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameControllerTest {

    private InputView inputView;
    private OutputView outputView;
    private RacingGameController racingGameController;

    @BeforeEach
    void init() {
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        racingGameController = new RacingGameController(inputView, outputView);
    }

    @Test
    @DisplayName("메소드 호출 횟수 테스트")
    void run_test() {
        when(inputView.inputCarNames()).thenReturn("Car1,Car2,Car3");
        when(inputView.inputTryNumber()).thenReturn("5");

        racingGameController.run();

        verify(outputView).printRequestCarNameMessage();
        verify(outputView).printRequestTryNumberMessage();

        verify(outputView).printResultMessage();

        verify(outputView, times(5)).printResult(any());

        verify(outputView).printWinners(any());
    }
}

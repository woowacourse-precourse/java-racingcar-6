package racingcar.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RaceControllerTest {

    private InputView inputView;
    private OutputView outputView;
    private RaceController raceController;

    @BeforeEach
    void setUp() {
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        raceController = new RaceController(inputView, outputView);
    }

    @Test
    void startRace_테스트() {
        when(inputView.inputCarNames()).thenReturn(Arrays.asList("a", "b", "c"));
        when(inputView.inputAttemptCount()).thenReturn(3);

        raceController.startRace();

        verify(outputView).printGameStartMessage();
        verify(outputView, times(3)).printRaceRoundResult(any(Cars.class));
        verify(outputView).printWinner(any(RaceResult.class));
    }


}
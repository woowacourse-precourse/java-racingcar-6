package study;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.domain.result.FinalResult;
import racingcar.model.RacingModel;
import racingcar.view.RacingView;
import racingcar.view.message.RacingMessage;

public class RacingControllerTest {
    private RacingModel mockRacingModel;
    private RacingView mockRacingView;
    private RacingController racingController;


    @BeforeEach
    public void setUp() {
        mockRacingModel = mock(RacingModel.class);
        mockRacingView = mock(RacingView.class);
        racingController = new RacingController(mockRacingModel, mockRacingView);
    }

    @Test
    public void testStart() {

        FinalResult finalResult = mock(FinalResult.class);

        when(mockRacingView.readInput()).thenReturn("pobi,woni,jun", "5");
        when(mockRacingModel.startRacing(any(String[].class), anyInt())).thenReturn(finalResult);

        racingController.start();

        verify(mockRacingView, times(1)).displayRacingMessage(RacingMessage.ASK_FOR_CAR_NAME);
        verify(mockRacingView, times(1)).displayRacingMessage(RacingMessage.ASK_FOR_ROUNDS);
        verify(mockRacingView, times(1)).displayFinalResult(any(FinalResult.class));
        verify(mockRacingView, times(1)).displayWinner(any(FinalResult.class));
    }
}

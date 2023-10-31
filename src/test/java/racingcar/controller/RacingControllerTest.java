package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RacingControllerTest {
    private RacingController racingController;

    @Mock
    private InputView inputView;

    @Mock
    private RacingService racingService;

    @Mock
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        racingController = new RacingController(inputView, racingService, outputView);
    }
    @Test
    void runShouldInteractWithInputViewRacingServiceAndOutputView() {
        List<String> carNames = Arrays.asList("용준", "용준1", "용준2");
        when(inputView.getCarNames()).thenReturn("용준,용준1,용준2");
        when(racingService.stringToList(anyString())).thenReturn(carNames);
        when(inputView.getTries()).thenReturn(3);

        racingController.run();

        verify(inputView, times(1)).getCarNames();
        verify(inputView, times(1)).getTries();
        verify(racingService, times(1)).stringToList(anyString());
        verify(outputView, times(1)).printGameResult(any());
    }
}
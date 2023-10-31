package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
}
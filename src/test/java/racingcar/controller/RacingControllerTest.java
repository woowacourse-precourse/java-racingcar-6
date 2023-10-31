package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.service.RacingService;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

class RacingControllerTest {
    private RacingService racingService;
    private RacingController racingController;

    @BeforeEach
    public void setUp() {
        racingService = Mockito.mock(RacingService.class);
        racingController = new RacingController(racingService);
    }

    @Test
    @DisplayName("시도횟수가_3일때_3번_수행되어야_한다")
    public void testStartRacing() throws Exception {
        // Given
        int attempt = 3;

        // When
        Method playRacingMethod = RacingController.class.getDeclaredMethod("playRacing", int.class);
        playRacingMethod.setAccessible(true);
        playRacingMethod.invoke(racingController, attempt);

        // Then
        verify(racingService, times(3)).playOneRacing();
    }
}
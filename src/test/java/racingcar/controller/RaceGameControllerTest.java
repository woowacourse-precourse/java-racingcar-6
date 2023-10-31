package racingcar.controller;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.InputValidator;
import racingcar.view.View;

class RaceGameControllerTest {

    private RaceGameController controller;
    private View viewMock;
    private InputValidator validatorMock;

    @BeforeEach
    public void setUp() {
        viewMock = mock(View.class);
        validatorMock = mock(InputValidator.class);

        controller = new RaceGameController(viewMock, validatorMock);
    }

    @Test
    @DisplayName("함수 호출 검증, 모킹")
    public void testStart() {
        when(viewMock.requestRaceCars()).thenReturn("car1,car2,car3");
        when(validatorMock.splitAndValidateCarNames("car1,car2,car3")).thenReturn(List.of("car1", "car2", ",car3"));

        when(viewMock.requestRaceRounds()).thenReturn("36");
        when(validatorMock.validateInputNumber("36")).thenReturn(36);

        controller.start();

        verify(viewMock).printRaceResult();
        verify(viewMock, times(36)).printRaceRoundResult(anyList());
        verify(viewMock).raceWinners(anyString());
    }

}
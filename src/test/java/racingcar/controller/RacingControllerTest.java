package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceParticipants;
import racingcar.domain.Round;
import racingcar.service.RacingService;
import racingcar.utils.InputReader;

class RacingControllerTest {

    private RacingService racingService;
    private InputReader inputReader;
    private RacingController racingController;

    @BeforeEach
    public void setup() {
        racingService = mock(RacingService.class);
        inputReader = mock(InputReader.class);
        racingController = new RacingController(racingService, inputReader);
    }

    @Test
    public void testStart() {
        when(inputReader.readLine())
                .thenReturn("car1, car2")
                .thenReturn("5");

        RaceParticipants mockParticipants = mock(RaceParticipants.class);
        Round mockRound = mock(Round.class);

        when(racingService.getWinner(mockParticipants)).thenReturn(List.of("car1"));

        racingController.start();

        verify(inputReader, times(2)).readLine();
        verify(racingService).startRound(any(RaceParticipants.class), any(Round.class));
        verify(racingService).getWinner(any(RaceParticipants.class));
    }

}
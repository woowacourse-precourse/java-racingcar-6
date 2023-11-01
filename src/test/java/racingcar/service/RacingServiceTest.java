package racingcar.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.domain.RaceParticipants;
import racingcar.domain.Round;

class RacingServiceTest {
    @Mock
    private RaceParticipants raceParticipants;

    @Mock
    private Round round;

    @InjectMocks
    private RacingService racingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testStartRound() {
        List<String> mockStatus = Arrays.asList("car1 : ", "car2 : ");
        when(raceParticipants.getRacingStatus()).thenReturn(mockStatus);
        when(round.isFinished()).thenReturn(false, false, true); // 2번 진행 후 종료
        racingService.startRound(raceParticipants, round);
        verify(raceParticipants, times(2)).getRacingStatus();
        verify(round, times(2)).finishOneRound();
    }

    @Test
    public void testGetWinner() {
        List<String> mockWinner = Arrays.asList("car1", "car2");
        when(raceParticipants.getWinner()).thenReturn(mockWinner);
        racingService.getWinner(raceParticipants);
        verify(raceParticipants, times(1)).getWinner();
    }

}
package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RacingcarServiceTest {
    private RacingcarService racingcarService;
    private Race mockRace;

    @BeforeEach
    public void setUp() {
        mockRace = mock(Race.class);
        racingcarService = new RacingcarService(mockRace);
    }

    @Test
    public void 레이스_라운드_실행_테스트() {
        racingcarService.raceRound();
        verify(mockRace, times(1)).raceRound();
    }

    @Test
    public void 레이스_종료_확인_테스트() {
        when(mockRace.isFinished()).thenReturn(true);

        boolean isFinished = racingcarService.isRaceFinished();

        assertTrue(isFinished);
        verify(mockRace, times(1)).isFinished();
    }

    @Test
    public void 레이스_우승자_가져오기_테스트() {
        racingcarService.getWinner();
        verify(mockRace, times(1)).getWinner();
    }

    @Test
    public void 레이스_상태_가져오기_테스트() {
        racingcarService.getRaceStatus();
        verify(mockRace, times(1)).getRaceStatus();
    }
}


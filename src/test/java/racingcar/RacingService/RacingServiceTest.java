package racingcar.RacingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static racingcar.view.InputView.getCarNamesFromUser;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = spy(RacingService.class);
    }

    @Test
    public void 자동차_이름_세팅_테스트() throws Exception {
        //given
        List<String> expected = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));

        doReturn(expected).when(racingService).getCarNameList();

        List<String> actual = racingService.getCarNameList();
        //when
        racingService.readyCarName();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void 시도할_횟수_세팅_테스트() throws Exception {
        //given
        int expected = 5;

        doReturn(5).when(racingService).getAttemptCount();

        int actual = racingService.getAttemptCount();
        //when
        racingService.readyAttemptCount();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void 레이싱할_자동차_등록() throws Exception {
        //given
        String expectedPobi = "pobi";
        String expectedWoni = "woni";
        String expectedJun = "jun";

        List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        doReturn(carNames).when(racingService).getCarNameList();

        racingService.readyCarName();

        //when
        racingService.readyCars();

        //then

        assertEquals(expectedPobi, racingService.getCars().get(0).getName());
        assertEquals(expectedWoni, racingService.getCars().get(1).getName());
        assertEquals(expectedJun, racingService.getCars().get(2).getName());
    }

}
package racingcar.RacingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.StubNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RacingServiceTest {

    private RacingService testService;

    @BeforeEach
    void setUp() {
        testService = spy(RacingService.class);
    }

    @Test
    public void 자동차_이름_세팅_테스트() throws Exception {
        //given
        List<String> expectedNames = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        doReturn(expectedNames).when(testService).getCarNameList();

        //when
        testService.readyCarName();
        List<String> actualNames = testService.getCarNameList();

        //then
        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void 시도할_횟수_세팅_테스트() throws Exception {
        //given
        int expectedAttemptCount = 5;
        doReturn(5).when(testService).getAttemptCount();


        //when
        testService.readyAttemptCount();
        int actualAttemptCount = testService.getAttemptCount();

        //then
        assertEquals(expectedAttemptCount, actualAttemptCount);
    }

    @Test
    public void 레이싱할_자동차_등록() throws Exception {
        //given
        String expectedPobi = "pobi";
        String expectedWoni = "woni";
        String expectedJun = "jun";

        List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        doReturn(carNames).when(testService).getCarNameList();

        testService.readyCarName();

        //when
        testService.readyCars(new RandomNumberGenerator());

        String actualPobi = testService.getCars().get(0).getName();
        String actualWoni = testService.getCars().get(1).getName();
        String actualJun = testService.getCars().get(2).getName();

        //then
        assertEquals(expectedPobi, actualPobi);
        assertEquals(expectedWoni, actualWoni);
        assertEquals(expectedJun, actualJun);
    }

    @Test
    public void 레이싱_1회_진행() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        doReturn(carNames).when(testService).getCarNameList();

        testService.readyCarName();
        testService.readyCars(new StubNumberGenerator(5));

        List<Car> cars = testService.getCars();

        int expectedPosition = 1;

        //when
        testService.playOneRound();

        //then
        for (Car car : cars) {
            int actualPosition = car.getPosition();
            assertEquals(expectedPosition, actualPosition);
        }
    }

    @Test
    public void 단독_우승자_찾기_테스트() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        doReturn(carNames).when(testService).getCarNameList();

        testService.readyCarName();

        NumberGenerator pobiMoveGenerator = new NumberGenerator() {
            private int count = 0;

            @Override
            public int generateNumberInRange() {
                count++;
                if (count % 3 == 1) {   // pobi
                    return 5;
                } else {    // woni, jun
                    return 0;
                }
            }
        };

        testService.readyCars(pobiMoveGenerator);

        List<Car> cars = testService.getCars();

        testService.playOneRound();

        String expectedWinningCarName = "pobi";

        //when
        String actualWinningCarName = testService.findWinner(cars);

        //then
        assertEquals(expectedWinningCarName, actualWinningCarName);
    }

    @Test
    public void 공동_우승자_찾기_테스트() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        doReturn(carNames).when(testService).getCarNameList();

        testService.readyCarName();
        testService.readyCars(new StubNumberGenerator(5));

        List<Car> cars = testService.getCars();

        testService.playOneRound();

        String expectedWinningCarName = "pobi, woni, jun";

        //when
        String actualWinningCarName = testService.findWinner(cars);

        //then
        assertEquals(expectedWinningCarName, actualWinningCarName);
    }
}
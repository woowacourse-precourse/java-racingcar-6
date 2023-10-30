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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
        racingService.readyCars(new RandomNumberGenerator());

        //then

        assertEquals(expectedPobi, racingService.getCars().get(0).getName());
        assertEquals(expectedWoni, racingService.getCars().get(1).getName());
        assertEquals(expectedJun, racingService.getCars().get(2).getName());
    }

    @Test
    public void 레이싱_1회_진행() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        doReturn(carNames).when(racingService).getCarNameList();

        racingService.readyCarName();
        racingService.readyCars(new StubNumberGenerator(5));

        List<Car> cars = racingService.getCars();

        //when
        racingService.playOneRound();

        //then
        for (Car car : cars) {
            assertEquals(1, car.getPosition());
        }
    }

    @Test
    public void 단독_우승자_찾기_테스트() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        doReturn(carNames).when(racingService).getCarNameList();

        racingService.readyCarName();

        // pobi만 move()할 수 있도록 랜덤함수 생성 재정의
        NumberGenerator numberGenerator = new NumberGenerator() {
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

        racingService.readyCars(numberGenerator);

        List<Car> cars = racingService.getCars();

        racingService.playOneRound();

        //when
        String actual = racingService.findWinner(cars);

        //then
        assertEquals("pobi", actual);
    }

    @Test
    public void 공동_우승자_찾기_테스트() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        doReturn(carNames).when(racingService).getCarNameList();

        racingService.readyCarName();
        racingService.readyCars(new StubNumberGenerator(5));

        List<Car> cars = racingService.getCars();

        racingService.playOneRound();

        //when
        String actual = racingService.findWinner(cars);

        //then
        assertEquals("pobi, woni, jun", actual);
    }

}
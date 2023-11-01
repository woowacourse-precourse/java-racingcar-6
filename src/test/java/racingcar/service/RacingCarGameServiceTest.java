package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.domain.GameResult;

class RacingCarGameServiceTest {
    private static final int MOVING_FORWARD = 4;


    private final RacingCarGameService racingCarGameService = new RacingCarGameService();
    final MockedStatic<Randoms> mock = mockStatic(Randoms.class);

    @AfterEach
    void setUpMock() {
        mock.close();
    }

    @Test
    void forwardOrStop() {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(Car.registerCar("pobi"));
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVING_FORWARD);


        //when
        List<Car> moveForwardCarList = racingCarGameService.forwardOrStop(carList);

        //then
        assertEquals(moveForwardCarList.get(0).getName(), "pobi");
        assertEquals(moveForwardCarList.get(0).getDistance(), 1);
    }

    @Test
    void winnerResult() {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(Car.registerCar("pobi"));
        carList.add(Car.registerCar("domo"));
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVING_FORWARD);

        //when
        GameResult gameResult = racingCarGameService.winnerResult(carList);
        List<Car> winnerList = gameResult.getWinners();

        //then
        Assertions.assertEquals(winnerList.get(0), carList.get(0));
        Assertions.assertEquals(winnerList.get(1), carList.get(1));
    }
}
package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.ResultRepository;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest extends NsTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RacingService racingService;
    private CarRepository carRepository;
    private ResultRepository resultRepository;

    @BeforeEach
    void setUp() {
        carRepository = CarRepository.getInstance();
        resultRepository = ResultRepository.getInstance();
        racingService = new RacingService(carRepository, resultRepository);
    }

    @Test
    void 게임_초기화_세팅_정상_테스트() {
        // given
        List<String> carNameList = List.of("ex1", "ex2");

        // when
        racingService.initializeGame(carNameList);

        //then
        assertEquals(2, carRepository.getCarList().size());
    }




    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
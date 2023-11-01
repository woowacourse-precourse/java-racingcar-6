package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.ResultRepository;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest extends NsTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final int STOP_ZERO = 0;

    private RacingService racingService;
    private CarRepository carRepository;
    private ResultRepository resultRepository;

    @BeforeEach
    void setUp() {
        carRepository = CarRepository.getInstance();
        resultRepository = ResultRepository.getInstance();
        racingService = new RacingService(carRepository, resultRepository);
        racingService.removeAll();
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

    @Test
    void 게임_정상_진행_테스트() {
        // given
        racingService.initializeGame(List.of("ex1", "ex2", "ex3"));

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> carList = racingService.progressRacing();
                    assertTrue(carList.stream().anyMatch(car -> car.getDistance() > 0));
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 전진_값_전체_0_테스트() {
        // given
        racingService.initializeGame(List.of("ex1", "ex2", "ex3"));

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> carList = racingService.progressRacing();
                    assertFalse(carList.stream().anyMatch(car -> car.getDistance() > 0));
                },
                STOP, STOP, STOP_ZERO
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"ex1, 0, ex2, 1, 1", "ex1, 1, ex2, 0, 1"})
    void 단일_우승자_저장_테스트(String firstName, int firstDistance, String secondName, int secondDistance, int expected) {
        //given
        carRepository.add(new Car(firstName, firstDistance));
        carRepository.add(new Car(secondName, secondDistance));

        // when
        List<Car> resultList = racingService.chooseWinner();

        // then
        assertThat(resultList.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"ex1, 1, ex2, 1, 2", "ex1, 0, ex2, 0, 2"})
    void 다중_우승자_저장_테스트(String firstName, int firstDistance, String secondName, int secondDistance, int expected) {
        //given
        carRepository.add(new Car(firstName, firstDistance));
        carRepository.add(new Car(secondName, secondDistance));

        // when
        List<Car> resultList = racingService.chooseWinner();

        // then
        assertThat(resultList.size()).isEqualTo(expected);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
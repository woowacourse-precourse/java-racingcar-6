package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Generator;

public class RacingServiceTest {
    private RacingService racingService;
    private CarRepository carRepository;

    @BeforeEach
    @Test
    void setUp() {
        carRepository = new CarRepository();
        racingService = new RacingService(carRepository);
    }

    @DisplayName("자동차 경주 준비 기능 테스트")
    @Test
    void testPrepareRace() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        racingService.prepareRace(carNames, 5);

        assertThat(carRepository.getCars().size()).isEqualTo(3);
    }

    @DisplayName("race 진행 여부 테스트")
    @Test
    void testIsRunning() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        racingService.prepareRace(carNames, 1);

        assertThat(racingService.isRunning()).isEqualTo(true);
    }

    @DisplayName("1회 경주 기능 테스트")
    @Test
    void testRunSingleRace() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        racingService.prepareRace(carNames, 1);
        racingService.runSingleRace();

        assertThat(racingService.isRunning()).isEqualTo(false);
    }

    @DisplayName("우승자 반환 테스트")
    @Test
    void testGetWinner() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        racingService.prepareRace(carNames, 1);

        assertThat(racingService.getWinner()).isEqualTo(carNames);
    }
}

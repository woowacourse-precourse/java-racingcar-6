package racingcar.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;

public class RacingServiceTest {
    private static final String TRY_COUNT = "5";

    private RacingService racingService;
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new MemoryCarRepository();
        racingService = new RacingServiceImpl(carRepository);
    }

    @Test
    void testRace() {
        List<String> carList = new ArrayList<>();
        carList.add("Car1");
        carList.add("Car2");

        racingService.race(carList, TRY_COUNT);

        assertThat(racingService.getRecord()).isNotEmpty();
    }


}
package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class RacingCarServiceTest {
    AppConfig appConfig;
    CarService carService;
    RacingGameService racingGameService;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        carService = appConfig.carService();
        racingGameService = appConfig.racingGameService();
    }

    @Test
    public void 새로운_게임_생성_성공() throws Exception {
        //given
        Car car1 = new Car("paek", 1L);
        Car car2 = new Car("paek2", 2L);
        List<Long> carsIdList = new ArrayList<>();
        carsIdList.add(1L);
        carsIdList.add(2L);

        //when
        carService.join(car1);
        carService.join(car2);
        RacingGame racingGame = racingGameService.createNewGame(carsIdList, 2, 1L);
        racingGameService.join(racingGame);

        //then
        assertThat(racingGameService.findGameById(1L).getCarsIdList().get(0)).isEqualTo(carsIdList.get(0));
    }
}

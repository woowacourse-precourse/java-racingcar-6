package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RacingGameServiceTest {

    @Test
    void testRaceSetting() {
        // given
        RacingGameService racingGameService = new RacingGameService();
        List<Car> carList = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        int playCount = 5;

        // when
        RacingGame racingGame = racingGameService.raceSetting(carList, playCount);

        // then
        assertEquals(5, racingGame.getRaceCount());
        assertEquals(3, racingGame.getCarList().size());
    }

    private RacingGameService racingGameService;
    private InputView inputView;
    private OutputView outputView;

    @BeforeEach
    void 초기세팅() {
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        racingGameService = new RacingGameService(inputView, outputView);
    }

    @Test
    void 경주횟수와_자동차리스트생성_확인() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        RacingGame game = racingGameService.raceSetting(cars, 3);
        assertNotNull(game);
        assertEquals(3, game.getRaceCount());
        assertEquals(2, game.getCarList().size());
    }

    

}
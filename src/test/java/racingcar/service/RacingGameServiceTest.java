package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameServiceTest {

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
    void 레이스_횟수_자동차리스트_생성_확인() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        RacingGame game = racingGameService.raceSetting(cars, 3);
        assertNotNull(game);
        assertEquals(3, game.getRaceCount());
        assertEquals(2, game.getCarList().size());
    }
}

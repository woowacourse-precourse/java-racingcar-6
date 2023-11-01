package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameServiceTest {

    private final RacingGameService racingGameService = new RacingGameService();

    @Test
    void 레이스_횟수_자동차리스트_생성_확인() {
        // given
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        RacingGame game = racingGameService.raceSetting(cars, 3);

        // when & then
        assertNotNull(game);
        assertEquals(3, game.getRaceCount());
        assertEquals(2, game.getCarList().size());
    }

    @Test
    void 우승자는_최소1명_이어야한다() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        RacingGame racingGame = new RacingGame(List.of(car1, car2, car3), 5);

        // when
        List<String> winners = racingGameService.checkWinner(racingGame);

        // then
        assertTrue(winners.size() >= 1);
        assertTrue(winners.contains("car1") || winners.contains("car2") || winners.contains("car3"));
    }

    @Test
    void 랜덤_값_범위_확인() {
        // given
        int power = racingGameService.makeRandomPower();

        // when & then
        assertTrue(power >= 0 && power <= 9);
    }


}

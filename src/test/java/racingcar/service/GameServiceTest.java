package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.DecideRule;
import racingcar.domain.car.Decider;
import racingcar.domain.car.Generator;
import racingcar.domain.car.Name;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.domain.car.Rule;

public class GameServiceTest {
    private final Rule rule = new DecideRule();
    private final Generator generator = new RandomNumberGenerator();
    private final Decider decider = Decider.of(rule, generator);
    @Test
    void 시도_횟수보다_적게_이동시켰다면_게임을_종료하지_않는다() {
        //given
        Name name = new Name("car");
        Car car = Car.withName(name);
        Cars cars = Cars.of(List.of(car), decider);
        Attempt attempt = Attempt.withNumber(1);
        GameService gameService = GameService.of(cars, attempt);

        //when
        gameService.tryToOff();

        //then
        assertFalse(gameService.isOver());
    }

    @Test
    void 시도_횟수만큼_시도했다면_게임을_종료한다() {
        //given
        Name name = new Name("car");
        Car car = Car.withName(name);
        Cars cars = Cars.of(List.of(car), decider);
        Attempt attempt = Attempt.withNumber(1);
        GameService gameService = GameService.of(cars, attempt);

        //when
        gameService.moveCars();
        gameService.tryToOff();

        //then
        assertTrue(gameService.isOver());
    }
}

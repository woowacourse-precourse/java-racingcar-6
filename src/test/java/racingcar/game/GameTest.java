package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

public class GameTest {
    @Test
    public void 게임_생성_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        Game game = new Game(cars, 3);
        assertNotNull(game);
    }
}

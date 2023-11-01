package racingcar.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

public class GameResultTest {
    @Test
    public void 게임결과_승자_테스트() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car1.move(4);
        car2.move(3);
        cars.add(car1);
        cars.add(car2);
        GameResult gameResult = new GameResult(cars);

        List<Car> winners = gameResult.findWinners();

        assertEquals(1, winners.size());
        assertTrue(winners.contains(car1));
        assertFalse(winners.contains(car2));
    }

    @Test
    public void 게임결과_동점자_테스트() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car1.move(4);
        car2.move(4);
        cars.add(car1);
        cars.add(car2);
        GameResult gameResult = new GameResult(cars);

        List<Car> winners = gameResult.findWinners();

        assertEquals(2, winners.size());
        assertTrue(winners.contains(car1));
        assertTrue(winners.contains(car2));
    }

    @Test
    public void 게임결과_패자_테스트() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car1.move(3);
        car2.move(4);
        cars.add(car1);
        cars.add(car2);
        GameResult gameResult = new GameResult(cars);

        List<Car> winners = gameResult.findWinners();

        assertEquals(1, winners.size());
        assertFalse(winners.contains(car1));
        assertTrue(winners.contains(car2));
    }
}

package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
class GameServiceTest {

    @Test
    void 경주_확인_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        int trial = 3;

        GameService gameService = new GameService(cars, trial);

        gameService.playRace();

    }

    @Test
    void 우승자_확인_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        cars.add(new Car("Car3"));

        cars.get(0).increaseScore();
        cars.get(1).increaseScore();
        cars.get(2).increaseScore();
        cars.get(2).increaseScore();

        GameService gameService = new GameService(cars, 1);

        List<String> winners = gameService.getWinners();

        assertEquals(1, winners.size());
        assertEquals("Car3", winners.get(0));
    }
}

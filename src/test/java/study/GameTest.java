package study;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.util.MessageProcessor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void createCarsTest() {
        String input = "car1,car2,car3";
        GameService gameService = new GameService(new MessageProcessor());

        List<Car> cars = gameService.createCars(input);

        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }

    @Test
    void playGameTest() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        MessageProcessor messageProcessor = new MessageProcessor();
        Game game = new Game(cars, 5, messageProcessor);

        game.play();
    }

    @Test
    void getWinnersTest() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Game game = new Game(cars, 5, new MessageProcessor());

        List<String> winners = game.getWinners();

        // You can check the expected winners based on a specific scenario.
    }

}

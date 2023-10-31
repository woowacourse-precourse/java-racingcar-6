package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.util.MessageProcessor;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {
    private GameController gameController;
    private MessageProcessor messageProcessor;
    private GameService gameService;

    @BeforeEach
    void setup() {
        messageProcessor = mock(MessageProcessor.class);
        gameService = mock(GameService.class);
        gameController = new GameController(messageProcessor, gameService);
    }

    @Test
    void runGame() {
        when(messageProcessor.getInput()).thenReturn("car1,car2,car3", "5");

        gameController.runGame();

    }

    @Test
    void createCars() {
        when(gameService.createCars("car1,car2,car3")).thenReturn(List.of(new Car("car1"), new Car("car2"), new Car("car3")));

        List<Car> cars = gameController.createCars("car1,car2,car3");

    }

    @Test
    void playGame() {
        gameController.playGame(List.of(new Car("car1"), new Car("car2"), new Car("car3")), 5);

    }
}

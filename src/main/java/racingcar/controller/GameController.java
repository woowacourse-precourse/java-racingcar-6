package racingcar.controller;


import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.util.MessageFactory;
import racingcar.util.MessageProcessor;

import java.util.List;

public class GameController {
    private final MessageProcessor messageProcessor;
    private final GameService gameService;

    public GameController(MessageProcessor messageProcessor, GameService gameService) {
        this.messageProcessor = messageProcessor;
        this.gameService = gameService;
    }

    public void runGame() {
        messageProcessor.print(MessageFactory.inputMessage);
        String input = messageProcessor.getInput();
        List<Car> cars = gameService.createCars(input);

        messageProcessor.print(MessageFactory.tryCountMessage);
        int tryCount = Integer.parseInt(messageProcessor.getInput());

        gameService.playGame(cars, tryCount);
    }
}

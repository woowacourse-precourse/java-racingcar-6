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
        List<Car> cars = createCars(input);

        messageProcessor.print(MessageFactory.tryCountMessage);
        int tryCount = Integer.parseInt(messageProcessor.getInput());

        playGame(cars, tryCount);
    }

    public List<Car> createCars(String input) {
        return gameService.createCars(input);
    }

    public void playGame(List<Car> cars, int tryCount) {
        gameService.playGame(cars, tryCount);
    }

}

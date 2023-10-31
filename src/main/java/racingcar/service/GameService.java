package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.MessageProcessor;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final MessageProcessor messageProcessor;

    public GameService(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }


    public List<Car> createCars(String input) {
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void playGame(List<Car> cars, int tryCount) {
        Game game = new Game(cars, tryCount, messageProcessor);
        game.play();
    }

}

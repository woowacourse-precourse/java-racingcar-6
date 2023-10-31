package racingcar;

import controller.GameController;
import controller.GameRule;
import controller.GameSetter;
import controller.RandomGameRuleImpl;
import model.CarList;

public class Application {
    public static void main(String[] args) {
        CarList carList = new CarList();
        GameSetter racingGame = new GameSetter(carList);
        GameRule randomGameRule = new RandomGameRuleImpl(carList);
        GameController gameController = new GameController(racingGame, randomGameRule);

        gameController.run();
    }
}

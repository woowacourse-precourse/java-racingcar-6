package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.GameRule;
import racingcar.configurator.GameSetter;
import racingcar.controller.RandomGameRuleImpl;
import racingcar.model.Cars;

public class Application {
    public static void main(String[] args) {
        Cars carList = new Cars();
        GameSetter gameSetter = new GameSetter(carList);
        GameRule randomGameRule = new RandomGameRuleImpl(carList);

        GameController gameController = new GameController(gameSetter, randomGameRule);
        gameController.run();
    }
}

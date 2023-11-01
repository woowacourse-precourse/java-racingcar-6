package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.GameRule;
import racingcar.configurator.GameSetter;
import racingcar.controller.RandomGameRuleImpl;
import racingcar.model.CarList;

public class Application {
    public static void main(String[] args) {
        CarList carList = new CarList();
        GameSetter gameSetter = new GameSetter(carList);
        GameRule randomGameRule = new RandomGameRuleImpl(carList);

        GameController gameController = new GameController(gameSetter, randomGameRule);
        gameController.run();
    }
}

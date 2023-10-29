package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.ForInputMessage;

public class InitService {

    private Game game = new Game();

    public void initCarList() {
        String carNameListString = ForInputMessage.forInputCarNamesMessage();
        game.validationCarNameAndSetGame(carNameListString);
    }
}

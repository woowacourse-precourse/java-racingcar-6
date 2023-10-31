package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;

public class GameInputController {
    InputView inputView;
    Cars cars;
    Game game;

    public void settingController() {
       inputView = new InputView();
       cars = new Cars();
       game = new Game(cars);
    }

    public void requestNames() {
        String names = inputView.requestNames();
        cars.settingNames(names);
    }

    public void requestTryNumber() {
        inputView.requestTryNumber();
        game.settingChance();
    }

    public Game sendGameInfo() {
        return game;
    }

}

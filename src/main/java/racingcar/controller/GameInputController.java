package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
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
        inputView.requestNames();
        cars.settingNames();
    }

    public void requestTryNumber() {
        inputView.requestTryNumber();
        game.settingChance();
    }

    public Game sendGameInfo() {
        return game;
    }

}

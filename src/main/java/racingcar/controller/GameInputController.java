package racingcar.controller;

import racingcar.Cars;
import racingcar.Game;
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

    //TODO: 게임 진행 요청
    //TODO: 시도 횟수마다 결과 출력 요청
    //TODO: 최종 우승자 출력 요청

}

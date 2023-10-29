package racingcar.controller;

import racingcar.Cars;
import racingcar.view.InputView;

public class GameInputController {
    InputView inputView;
    Cars cars;

    public void settingController() {
       inputView = new InputView();
       cars = new Cars();
    }

    public void requestNames() {
        inputView.requestNames();
        cars.settingNames();
    }

    //TODO: 시도 횟수 입력 요청
    //TODO: 게임 진행 요청
    //TODO: 시도 횟수마다 결과 출력 요청
    //TODO: 최종 우승자 출력 요청

}

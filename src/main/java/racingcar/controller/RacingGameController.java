package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGameView racingGameView;

    public RacingGameController(RacingGameView racingGameView){
        this.racingGameView = racingGameView;
    }

    // 1. 자동차 이름 입력받는 기능
    public String inputCarName(){
        racingGameView.showCarNameInputMessage();
        String carName = Console.readLine();

        return carName;
    }

    // 2. 시도할 회수 입력받는 기능
    public Integer inputTrialNumber(){
        racingGameView.showTrialNumberInputMessage();
        String inputValue = Console.readLine();

        return Integer.valueOf(inputValue);
    }
}

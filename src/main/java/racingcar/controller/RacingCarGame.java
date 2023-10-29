package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {

    public void runGame(){
        List<String> carNameList = InputView.inputCarName();

        int countNumber = InputView.inputCount();

        System.out.println(carNameList);
        System.out.println(countNumber);
    }
}

package racingcar.controller;

import racingcar.view.OutputView;

public class GameController {
    public void playGame(){
        OutputView outputView = new OutputView();
        outputView.askToInsertCarNames();
    }
}
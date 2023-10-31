package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class Game {
    private Integer round;

    public void run(){
        OutputView.startGame();
        ArrayList<String> input = Parser.parsingByComma(InputView.readLine());
    }

    private void askGameRounds(){

    }

    private void makeRandomNumber(){

    }

    private void mainLogic(){

    }

    private void result(){

    }
}

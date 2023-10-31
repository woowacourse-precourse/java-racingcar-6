package racingcar.controller;

import racingcar.game.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class Game {
    private Integer round;
    private Cars cars;

    public void run(){
        OutputView.startGame();
        ArrayList<String> input = Parser.parsingByComma(InputView.readLine());
        cars = new Cars(input);
        askGameRounds();
    }

    private void askGameRounds(){
        OutputView.askGameRounds();
        round = Parser.parsingInteger(InputView.readLine());
    }

    private void mainLogic(){

    }

    private void result(){

    }
}

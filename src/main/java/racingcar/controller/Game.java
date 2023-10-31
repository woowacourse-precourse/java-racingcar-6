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
        OutputView.startGameResult();
        mainLogic();
    }

    private void askGameRounds(){
        OutputView.askGameRounds();
        round = Parser.parsingInteger(InputView.readLine());
    }

    private void mainLogic(){
        for(int i=0; i<round; i++){
            cars.roundRace();
            OutputView.theEndOfRound();
        }
    }

    private void result(){

    }
}

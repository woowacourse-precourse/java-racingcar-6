package racingcar.controller;

import racingcar.game.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private Integer round;
    private Cars cars;

    public void run(){
        OutputView.startGame();
        cars = new Cars(InputView.readCarNames());
        askGameRounds();
        OutputView.startGameResult();
        mainLogic();
        result();
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
        cars.getWinners();
    }
}

package racingcar.controller;

import racingcar.view.GameView;
import racingcar.domain.RacingCars;

public class Controller {
    private final static GameView gameView = new GameView();
    public void play(){
        String carNames= gameView.inputCarNames();
        RacingCars racingCars = new RacingCars(carNames);

        int trialNum = gameView.inputTrialGame();

        gameView.printResultHead();

        for(int i=0; i<trialNum; i++){
            racingCars.movingRacingCars();
            gameView.printCarStatus(racingCars.getCars());
        }
        gameView.printWinner(racingCars.getCars());

    }

}

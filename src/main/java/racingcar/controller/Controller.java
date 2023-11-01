package racingcar.controller;

import racingcar.view.GameView;
import racingcar.domain.RacingCars;

public class Controller {
    private final static GameView gameView = new GameView();
    public void play(){
        String carNames= gameView.inputCarNames();
        RacingCars racingCars = new RacingCars(carNames);

        String trialNumStr = gameView.inputTrialGame();
        int trialNum = validTrialUserInput(trialNumStr);

        gameView.printResultHead();

        for(int i=0; i<trialNum; i++){
            racingCars.movingRacingCars();
            gameView.printCarStatus(racingCars.getCars());
        }
        gameView.printWinner(racingCars.getCars());

    }
    private int validTrialUserInput(String trialNumStr) {

        try {
            int trialNum = Integer.parseInt(trialNumStr);
            return trialNum;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}


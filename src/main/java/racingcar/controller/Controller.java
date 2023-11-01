package racingcar.controller;

import racingcar.view.GameView;
import racingcar.domain.RacingCars;

public class Controller {
    private final static GameView gameView = new GameView();
    public void play(){
        RacingCars racingCars = getValidRacingCars();

        String trialNumStr = gameView.inputTrialGame();
        int trialNum = validTrialUserInput(trialNumStr);

        gameView.printResultHead();

        for(int i=0; i<trialNum; i++){
            racingCars.movingRacingCars();
            gameView.printCarStatus(racingCars.getCars());
        }
        gameView.printWinner(racingCars.getCars());
    }
    private RacingCars getValidRacingCars() {
        String carNames = gameView.inputCarNames();
        validCarsUserInput(carNames);
        return new RacingCars(carNames);
    }
    private int validTrialUserInput(String trialNumStr) {
        try {
            int trialNum = Integer.parseInt(trialNumStr);
            return trialNum;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
    private void validCarsUserInput(String carNames){
        String[] carNameIndexs = carNames.split(",");

        for (String carName : carNameIndexs) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        if (carNameIndexs.length < 2) {
            throw new IllegalArgumentException("두 대 이상의 자동차 이름이 필요합니다.");
        }
    }
}


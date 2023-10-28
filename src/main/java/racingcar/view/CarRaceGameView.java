package racingcar.view;

import racingcar.constant.GameConstants;

public class CarRaceGameView {
    private static CarRaceGameView carRaceGameView = null;

    public static CarRaceGameView getCarRaceGameView() {
        if(carRaceGameView == null){
            carRaceGameView = new CarRaceGameView();
        }
        return carRaceGameView;
    }

    public void startGameView() {
        System.out.println(GameConstants.START_GAME);
    }
}

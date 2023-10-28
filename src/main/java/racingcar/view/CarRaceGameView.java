package racingcar.view;

import racingcar.constant.GameConstants;
import static camp.nextstep.edu.missionutils.Console.*;

public class CarRaceGameView {
    private static CarRaceGameView carRaceGameView = null;

    public static CarRaceGameView getCarRaceGameView() {
        if(carRaceGameView == null){
            carRaceGameView = new CarRaceGameView();
        }
        return carRaceGameView;
    }

    public String startGameView() {
        System.out.println(GameConstants.START_GAME);
        return readLine();
    }
}
